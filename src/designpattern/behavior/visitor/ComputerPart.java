package designpattern.behavior.visitor;

public abstract class ComputerPart {
	abstract void accept(Visitor visitor);
}
