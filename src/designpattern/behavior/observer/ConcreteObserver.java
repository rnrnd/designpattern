package designpattern.behavior.observer;

public class ConcreteObserver implements Observer{
	@Override
	public void update(Observable observable, Object args) {
		System.out.println(observable.getClass());
	}
}
