package parser.ast;

import static java.util.Objects.requireNonNull;

public class MyLangProg implements Prog {
	private final Exp exp;

	public MyLangProg(Exp exp) {
		this.exp = requireNonNull(exp);
	}

	@Override
	public String toString() {
		return String.format("%s(%s)", getClass().getSimpleName(), exp);
	}
}
