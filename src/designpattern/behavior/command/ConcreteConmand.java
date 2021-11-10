package designpattern.behavior.command;

public class ConcreteConmand implements Command{
	//多个执行者的话可以用list或者vector等容器，并添加add方法
	private Receiver receiver;

	public ConcreteConmand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.doSomething();
	}

	@Override
	public void undo() {

	}
}
