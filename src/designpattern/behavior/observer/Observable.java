package designpattern.behavior.observer;

import java.util.Vector;

public class Observable {
	private Vector<Observer> observers;

	public Observable() {
		this.observers = new Vector<>();
	}
	public Observable addObserver(Observer observer) {
		observers.add(observer);
		return this;
	}
	public Observable deleteObserver(Observer observer) {
		observers.remove(observer);
		return this;
	}
	public void notifyObservers(){
		this.notifyObservers(null);
	}
	public void notifyObservers(Object args) {
		for (Observer observer : observers) {
			observer.update(this, args);
		}
	}
}
