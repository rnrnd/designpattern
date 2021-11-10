package designpattern.behavior.interpreter;

public class NonterminalExpression implements Expression {
	public NonterminalExpression(Expression... expressions) {

	}

	@Override
	public Object interpret(Context context) {
		return null;
	}
}
