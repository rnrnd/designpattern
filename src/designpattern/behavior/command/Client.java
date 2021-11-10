package designpattern.behavior.command;

/**
 * 命令模式是一个高内聚的模式，定义是：讲一个请求封装成一个对象，从而让你使用不同的请求参数把客户端参数化，
 * 队请求排队，或者记录请求日志，可以提供命令的撤销和恢复功能
 * 简而言之，就是使请求命令的和执行命令的解耦
 */
public class Client {
	public static void main(String[] args) {
		Receiver receiver = new ConcreteReceiver();
		Command command = new ConcreteConmand(receiver);
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.action();

	}
}
