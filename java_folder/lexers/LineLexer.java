package lexers;

import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineLexer implements Lexer {

	private final Matcher matcher;
	private MatchResult result; // risultato dell'ultimo match che ha avuto successo; definito solo se il metodo
								// 'reset()' non è stato chiamato

	private MatchResult getResult() {
		if (this.result == null)
			throw new IllegalStateException();
		return this.result;
	}

	protected LineLexer(String line, String regEx) {
		this.matcher = Pattern.compile(regEx).matcher(line);
	}

	public static LineLexer withLineRegex(String line, String regEx) {
		return new LineLexer(line, regEx);
	}

	public static LineLexer withRegex(String regEx) {
		return new LineLexer("", regEx);
	}

	/*
	 * restituisce il prossimo lessema a partire dalla posizione corrente nella linea e avanza
	 * nella linea;
	 * restituisce null se nessun lessema valido viene riconosciuto, la posizione corrente rimane invariata
	 *
	 */
	public String next() {
	    // completare

	}


	/*
	 * restituisce il gruppo del lessema appena riconosciuto definito dall'espressione regolare associata
	 * al lexer
	 * solleva java.lang.IllegalStateException se prima
	 * - next() non e` stato chiamato
	 * - oppure next() e` stato chiamato, ma ha restituito null
	 * - oppure reset(String line) e` stato chiamato
	 */
	public int group() {
	    // completare
	}

	public boolean hasNext() {
	    // completare
	}

	public void reset(String line) {
	    // completare
	}

}
