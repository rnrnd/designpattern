package designpattern.behavior.visitor;

public interface Visitor {
	void visit(CPU cpu);
	void visit(Memory memory);
	void visit(MotherBoard motherBoard);
}
