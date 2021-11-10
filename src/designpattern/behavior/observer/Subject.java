package designpattern.behavior.observer;

public class Subject extends Observable{

	public void doSomething(){
		/**
		 * do something
		 */
		super.notifyObservers();
	}
}
