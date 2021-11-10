package designpattern.behavior.interpreter.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * 分词器，将一段源码分割成有序的Token集合
 * 词法分析，也叫做扫描scanner。它读取我们的代码，然后把它们按照预定的规则合并成一个个的标识tokens。同时，它会移除空白符，注释，等。最后，整个代码将被分割进一个tokens列表（或者说一维数组）。
 */
public class Tokenizer {
	private String expressionString;

	private char[] charsToProcess;

	private int pos;

	private int max;

	private List<Token> tokens = new ArrayList<>();


	public Tokenizer(String inputData) {
		this.expressionString = inputData;
		this.charsToProcess = (inputData + "\0").toCharArray();
		this.max = this.charsToProcess.length;
		this.pos = 0;
	}
	public List<Token> process(){
		while (this.pos < this.max) {
			char ch = this.charsToProcess[this.pos];
			switch (ch) {
				case '+':
					if (isTwoCharToken(TokenKind.INC)) {
						pushPairToken(TokenKind.INC);
					}
					else {
						pushCharToken(TokenKind.PLUS);
					}
					break;
				case '-':
					if (isTwoCharToken(TokenKind.DEC)) {
						pushPairToken(TokenKind.DEC);
					}
					else {
						pushCharToken(TokenKind.MINUS);
					}
					break;
				case '*':
					pushCharToken(TokenKind.STAR);
					break;
				case '/':
					pushCharToken(TokenKind.DIV);
					break;
				case '(':
					pushCharToken(TokenKind.LPAREN);
					break;
				case ')':
					pushCharToken(TokenKind.RPAREN);
					break;
				default:
					throw new IllegalStateException("Cannot handle (" + (int) ch + ") '" + ch + "'");
			}
		}
		return tokens;
	}
	private void pushCharToken(TokenKind kind) {
		this.tokens.add(new Token(kind, this.pos, this.pos + 1));
		this.pos++;
	}
	private void pushPairToken(TokenKind kind) {
		this.tokens.add(new Token(kind, this.pos, this.pos + 2));
		this.pos += 2;
	}
	private boolean isTwoCharToken(TokenKind kind) {
		return (kind.tokenChars.length == 2 &&
				this.charsToProcess[this.pos] == kind.tokenChars[0] &&
				this.charsToProcess[this.pos + 1] == kind.tokenChars[1]);
	}
}
