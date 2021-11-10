package designpattern.behavior.visitor;

public class CPU extends ComputerPart{
	@Override
	void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
