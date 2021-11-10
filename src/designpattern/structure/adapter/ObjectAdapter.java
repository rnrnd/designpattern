package designpattern.structure.adapter;

public class ObjectAdapter implements Target{

	Adaptee adaptee;

	public ObjectAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void request() {
		adaptee.doSomething();
	}
}
