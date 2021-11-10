package designpattern.structure.adapter;

public class ClassAdapter extends ConcreteAdptee implements  Target{
	@Override
	public void request() {
		super.doSomething();
	}
}
