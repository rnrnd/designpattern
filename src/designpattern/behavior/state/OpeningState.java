package designpattern.behavior.state;

public class OpeningState extends State{
	//这是本状态对象的主要业务逻辑的体现
	@Override
	public void open() {
		System.out.println("open...");
	}

	@Override
	public void close() {
		super.context.transferState(Context.closingState);
		super.context.close();
	}

	@Override
	public void run() {
		//开门状态不允许运行
		throw new IllegalStateException("开门状态不允许运行");
	}

	@Override
	public void stop() {
		//开门状态本来就是以停止状态为前提
		throw new IllegalStateException("开门状态本来就是以停止状态为前提");
	}
}
