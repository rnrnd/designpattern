package designpattern.behavior.interpreter.ast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 解析器，语法分析，将词法分析出来的数组转化成树形的表达形式。同时，验证语法，语法如果有错的话，抛出语法错误。
 */
public class Parser {
	private String expressionString = "";
	private List<Token> tokenStream = Collections.emptyList();
	public Expression parse(String expressionString){
		this.expressionString = expressionString;
		Tokenizer tokenizer = new Tokenizer(expressionString);
		tokenStream = tokenizer.process();
		AstNode ast = generateAbstractSyntaxTree();
		return new Expression(ast);
	}
	private AstNode generateAbstractSyntaxTree(){
		for (Token token : tokenStream) {

		}
		return new AstNode();
	}
}
