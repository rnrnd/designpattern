package designpattern.behavior.state;

public class RunningState extends State{
	@Override
	public void open() {
		throw new IllegalStateException("运行状态不允许开门");
	}

	@Override
	public void close() {
		throw new IllegalStateException("运行状态肯定是关门的");
	}

	@Override
	public void run() {
		System.out.println("running...");
	}

	@Override
	public void stop() {
		super.context.transferState(Context.stoppingState);
		super.context.stop();
	}
}
