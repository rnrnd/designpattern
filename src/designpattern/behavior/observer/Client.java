package designpattern.behavior.observer;

public class Client {
	public static void main(String[] args) {
		Subject subject = new Subject();
		Observer observer = new ConcreteObserver();
		subject.addObserver(observer);
		subject.doSomething();
	}
}
