package designpattern.behavior.state;

public class StoppingState extends State{
	@Override
	public void open() {
		super.context.transferState(Context.openingState);
		super.context.open();
	}

	@Override
	public void close() {
		throw new IllegalStateException("停止状态本来就是关门的，只有open状态执行close才有意义");
	}

	@Override
	public void run() {
		super.context.transferState(Context.runningState);
		super.context.run();
	}

	@Override
	public void stop() {
		System.out.println("stop...");
	}
}
