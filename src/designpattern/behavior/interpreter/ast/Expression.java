package designpattern.behavior.interpreter.ast;

/**
 * 表达式，parser解析之后生成expression，expression包含了语法树及其他信息
 */
public class Expression {
	private AstNode ast;

	public Expression(AstNode ast) {
		this.ast = ast;
	}

	public Object getValue(){
		return ast.getValue();
	}
}
