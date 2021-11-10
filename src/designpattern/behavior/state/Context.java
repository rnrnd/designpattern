package designpattern.behavior.state;

public class Context {
	public static final State openingState = new OpeningState();
	public static final State closingState = new ClosingState();
	public static final State runningState = new RunningState();
	public static final State stoppingState = new StoppingState();

	private State currentState;

	public State getCurrentState() {
		return currentState;
	}
	public void transferState(State currentState){
		this.currentState = currentState;
		currentState.setContext(this);
	}
	public void open(){
		currentState.open();
	}
	public void close(){
		currentState.close();
	}
	public void run(){
		currentState.run();
	}
	public void stop(){
		currentState.stop();
	}
}
