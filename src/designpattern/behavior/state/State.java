package designpattern.behavior.state;

public abstract class State {
	protected Context context;

	public void setContext(Context context) {
		this.context = context;
	}

	abstract void open();
	abstract void close();
	abstract void run();
	abstract void stop();
}
