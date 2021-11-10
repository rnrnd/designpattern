package designpattern.behavior.state;

public class ClosingState extends State{
	@Override
	public void open() {
		super.context.transferState(Context.openingState);
		super.context.open();
	}

	@Override
	public void close() {
		System.out.println("close...");
	}

	@Override
	public void run() {
		super.context.transferState(Context.runningState);
		super.context.run();
	}

	@Override
	public void stop() {
		super.context.transferState(Context.stoppingState);
		super.context.stop();
	}
}
