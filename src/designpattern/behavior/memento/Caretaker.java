package designpattern.behavior.memento;

import java.util.Stack;

public class Caretaker {
	private Stack<IMemento> mementos = new Stack<>();
	public void saveMemento(IMemento memento) {
		mementos.push(memento);
	}
	public IMemento popMemento(){
		return mementos.pop();
	}
}
