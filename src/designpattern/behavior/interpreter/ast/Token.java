package designpattern.behavior.interpreter.ast;

/**
 * 语法基本单元，分词器分出来的一个个单词
 */
public class Token {
	TokenKind kind;

	String data;

	int startPos;  // index of first character

	int endPos;  // index of char after the last character

	Token(TokenKind tokenKind, int startPos, int endPos) {
		this.kind = tokenKind;
		this.startPos = startPos;
		this.endPos = endPos;
	}
}
