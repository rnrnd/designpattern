package designpattern.behavior.command;

public class ConcreteReceiver implements Receiver{
	@Override
	public void doSomething() {
		System.out.println("接收者干活");
	}
}
