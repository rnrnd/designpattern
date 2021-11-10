package designpattern.behavior.memento;

public class Originator {

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Originator{" +
				"state='" + state + '\'' +
				'}';
	}

	public Memento createMemento() {
		return new Memento(state);
	}
	public void restoreMemento(IMemento memento){
		this.state = ((Memento)memento).getState();
	}
	private class Memento implements IMemento {
		private String state;

		public Memento(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
	}
}
