package designpattern.behavior.memento;

/**
 * 定义的备忘录接口是空的，需要使用备忘录时，在Originator里定义私有的实现类,并定义创建备忘录的工厂方法
 * Caretaker持有的是空接口，所以对备忘录内容并不掌握，只负责存储
 */
public class Client {
	public static void main(String[] args) {
		Caretaker caretaker = new Caretaker();
		Originator originator = new Originator();
		originator.setState("state0");
		caretaker.saveMemento(originator.createMemento());
		originator.setState("state1");
		caretaker.saveMemento(originator.createMemento());
		originator.setState("state2");
		System.out.println(originator);
		originator.restoreMemento(caretaker.popMemento());
		System.out.println(originator);
		originator.restoreMemento(caretaker.popMemento());
		System.out.println(originator);
		originator.restoreMemento(caretaker.popMemento());
		System.out.println(originator);
	}
}
