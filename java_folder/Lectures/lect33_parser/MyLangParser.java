package parser;

import static java.util.Objects.requireNonNull;
import static parser.TokenType.*;
import java.io.IOException;

import parser.ast.*;

/*
Prog ::= Exp EOF
Exp ::= Mul ('+' Mul)*      
Mul ::= Atom ('*' Atom)*    
Atom ::= Num | '(' Exp ')'  
Num ::= '0' | '1' 
*/

public class MyLangParser implements Parser {

	private final MyLangTokenizer tokenizer; // the tokenizer used by the parser

	/*
	 * reads the next token through the buffered tokenizer associated with the
	 * parser; TokenizerExceptions are chained into corresponding ParserExceptions
	 */
	private void nextToken() throws ParserException {
		try {
			tokenizer.next();
		} catch (TokenizerException e) {
			throw new ParserException(e);
		}
	}

	// decorates error message with the corresponding line number
	private String lineErrMsg(String msg) {
		return String.format("on line %s: %s", tokenizer.getLineNumber(), msg);
	}

	/*
	 * checks whether the token type of the currently recognized token matches
	 * 'expected'; if not, it throws a corresponding ParserException
	 */
	private void match(TokenType expected) throws ParserException {
		final var found = tokenizer.tokenType();
		if (found != expected)
			throw new ParserException(lineErrMsg(
					String.format("Expecting %s, found %s('%s')", expected, found, tokenizer.tokenString())));
	}

	/*
	 * checks whether the token type of the currently recognized token matches
	 * 'expected'; if so, it reads the next token, otherwise it throws a
	 * corresponding ParserException
	 */
	private void consume(TokenType expected) throws ParserException {
		match(expected);
		nextToken();
	}

	// throws a ParserException because the current token was not expected
	private <T> T unexpectedTokenError() throws ParserException {
		throw new ParserException(
				lineErrMsg(String.format("Unexpected token %s('%s')", tokenizer.tokenType(), tokenizer.tokenString())));
	}

	// associates the parser with a corresponding non-null buffered tokenizer
	public MyLangParser(MyLangTokenizer tokenizer) {
		this.tokenizer = requireNonNull(tokenizer);
	}

	@Override
	public void close() throws IOException {
		if (tokenizer != null)
			tokenizer.close();
	}

	/*
	 * parses a program Prog ::= Exp EOF
	 */
	@Override
	public Prog parseProg() throws ParserException {
		nextToken(); // one lookahead token
		final var prog = new MyLangProg(parseExp());
		match(EOF); // last token must have type EOF
		return prog;
	}

	/*
	 * parses expressions, starting from the lowest precedence operator PLUS which
	 * is left-associative Exp ::= Mul ('+' Mul)*
	 */

	private Exp parseExp() throws ParserException {
		var exp = parseMul();
		while (tokenizer.tokenType() == PLUS) {
			nextToken();
			exp = new Add(exp, parseMul());
		}
		return exp;
	}

	/*
	 * parses expressions with operator TIMES which is left-associative Mul::= Atom
	 * ('*' Atom)*
	 */
	private Exp parseMul() throws ParserException {
		var exp = parseAtom();
		while (tokenizer.tokenType() == TIMES) {
			nextToken();
			exp = new Mul(exp, parseAtom());
		}
		return exp;
	}

	/*
	 * parses expressions of type Atom Atom ::= NUM | '(' Exp ')'
	 */
	private Exp parseAtom() throws ParserException {
		return switch (tokenizer.tokenType()) {
			case NUM -> parseNum();
			case OPEN_PAR -> parseRoundPar();
			default -> unexpectedTokenError();
		};
	}

	// parses number literals
	private IntLiteral parseNum() throws ParserException {
		final var val = tokenizer.intValue();
		consume(NUM); // or nextToken() since NUM has already been recognized
		return new IntLiteral(val);
	}

	/*
	 * parses expressions delimited by parentheses Atom ::= '(' Exp ')'
	 */

	private Exp parseRoundPar() throws ParserException {
		consume(OPEN_PAR); // this check is necessary for parsing correctly the 'if' statement
		final var exp = parseExp();
		consume(CLOSE_PAR);
		return exp;
	}

}