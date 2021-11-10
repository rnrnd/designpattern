package designpattern.behavior.interpreter.ast;

public enum TokenKind {
	LPAREN("("),

	RPAREN(")"),

	PLUS("+"),

	STAR("*"),

	MINUS("-"),

	DIV("/"),

	INC("++"),

	DEC("--");

	final char[] tokenChars;

	private final boolean hasPayload;  // is there more to this token than simply the kind
	private TokenKind(String tokenString) {
		this.tokenChars = tokenString.toCharArray();
		this.hasPayload = (this.tokenChars.length == 0);
	}
}
