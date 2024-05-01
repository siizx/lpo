package lab08.parser;

import java.io.IOException;

import lab08.parser.ast.*;

import static java.util.Objects.requireNonNull;
import static lab08.parser.TokenType.*;


/*
Prog ::= StmtSeq EOF
StmtSeq ::= Stmt (';' StmtSeq)?
Stmt ::= 'var'? IDENT '=' Exp | 'print' Exp |  'if' '(' Exp ')' Block ('else' Block)? 
Block ::= '{' StmtSeq '}'
Exp ::= And (',' And)* 
And ::= Eq ('&&' Eq)* 
Eq ::= Add ('==' Add)*
Add ::= Mul ('+' Mul)*
Mul::= Atom ('*' Atom)*
Atom ::= 'fst' Atom | 'snd' Atom | '-' Atom | '!' Atom | BOOL | NUM | IDENT | '(' Exp ')'
*/

public class MyLangParser implements Parser {

	private final MyLangTokenizer tokenizer; // the tokenizer used by the parser

	/*
	 * reads the next token through the  tokenizer associated with the
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
			throw new ParserException(
					lineErrMsg(String.format("Expecting %s, found %s('%s')", expected, found, tokenizer.tokenString())));
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
		throw new ParserException(lineErrMsg(
				String.format("Unexpected token %s ('%s')", tokenizer.tokenType(), tokenizer.tokenString())));
	}

	// associates the parser with a corresponding non-null  tokenizer
	public MyLangParser(MyLangTokenizer tokenizer) {
		this.tokenizer = requireNonNull(tokenizer);
	}

	/*
	 * parses a program Prog ::= StmtSeq EOF
	 */
	@Override
	public Prog parseProg() throws ParserException {
		nextToken(); // one look-ahead symbol
		final var prog = new MyLangProg(parseStmtSeq());
		match(EOF); // last token must have type EOF
		return prog;
	}

	@Override
	public void close() throws IOException {
		if (tokenizer != null)
			tokenizer.close();
	}

	/*
	 * parses a non empty sequence of statements, binary operator STMT_SEP is right
	 * associative StmtSeq ::= Stmt (';' StmtSeq)?
	 */
	private StmtSeq parseStmtSeq() throws ParserException {
	    //  completare
	}

	/*
	 * parses a statement Stmt ::= 'var'? IDENT '=' Exp | 'print' Exp | 'if' '(' Exp
	 * ')' Block ('else' Block)?
	 */
	private Stmt parseStmt() throws ParserException {
		return switch (tokenizer.tokenType()) {
		case PRINT -> parsePrintStmt();
		case VAR -> parseVarStmt();
		case IDENT -> parseAssignStmt();
		case IF -> parseIfStmt();
		default -> unexpectedTokenError();
		};
	}

	/*
	 * parses the 'print' statement Stmt ::= 'print' Exp
	 */
	private PrintStmt parsePrintStmt() throws ParserException {
	    // completare
	}

	/*
	 * parses the 'var' statement Stmt ::= 'var' IDENT '=' Exp
	 */
	private VarStmt parseVarStmt() throws ParserException {
	    // completare
	}

	/*
	 * parses the assignment statement Stmt ::= IDENT '=' Exp
	 */
	private AssignStmt parseAssignStmt() throws ParserException {
	    // completare
	}

	/*
	 * parses the 'if' statement Stmt ::= 'if' '(' Exp ')' Block ('else' Block)?
	 */
	private IfStmt parseIfStmt() throws ParserException {
	    // completare
	}

	/*
	 * parses a block of statements Block ::= '{' StmtSeq '}'
	 */
	private Block parseBlock() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions, starting from the lowest precedence operator PAIR_OP
	 * which is left-associative Exp ::= And (',' And)*
	 */

	private Exp parseExp() throws ParserException {
		var exp = parseAnd();
		while (tokenizer.tokenType() == PAIR_OP) {
			nextToken();
			exp = new PairLit(exp, parseAnd());
		}
		return exp;
	}

	/*
	 * parses expressions, starting from the lowest precedence operator AND which is
	 * left-associative And ::= Eq ('&&' Eq)*
	 */
	private Exp parseAnd() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions, starting from the lowest precedence operator EQ which is
	 * left-associative Eq ::= Add ('==' Add)*
	 */
	private Exp parseEq() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions, starting from the lowest precedence operator PLUS which
	 * is left-associative Add ::= Mul ('+' Mul)*
	 */
	private Exp parseAdd() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions, starting from the lowest precedence operator TIMES which
	 * is left-associative Mul::= Atom ('*' Atom)*
	 */
	private Exp parseMul() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions of type Atom Atom ::= 'fst' Atom | 'snd' Atom | '-' Atom |
	 * '!' Atom | BOOL | NUM | IDENT | '(' Exp ')'
	 */
	private Exp parseAtom() throws ParserException {
		return switch (tokenizer.tokenType()) {
		case NUM -> parseNum();
		case IDENT -> parseVariable();
		case MINUS -> parseMinus();
		case OPEN_PAR -> parseRoundPar();
		case BOOL -> parseBoolean();
		case NOT -> parseNot();
		case FST -> parseFst();
		case SND -> parseSnd();
		default -> unexpectedTokenError();
		};
	}

	// parses number literals
	private IntLiteral parseNum() throws ParserException {
	    // completare
	}

	// parses boolean literals
	private BoolLiteral parseBoolean() throws ParserException {
	    // completare
	}

	// parses variable identifiers
	private Variable parseVariable() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions with unary operator MINUS Atom ::= '-' Atom
	 */
	private Sign parseMinus() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions with unary operator FST Atom ::= 'fst' Atom
	 */
	private Fst parseFst() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions with unary operator SND Atom ::= 'snd' Atom
	 */
	private Snd parseSnd() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions with unary operator NOT Atom ::= '!' Atom
	 */
	private Not parseNot() throws ParserException {
	    // completare
	}

	/*
	 * parses expressions delimited by parentheses Atom ::= '(' Exp ')'
	 */

	private Exp parseRoundPar() throws ParserException {
	    // completare
	}

}
