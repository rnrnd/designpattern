package designpattern.behavior.iterator;

public class Client {
	public static void main(String[] args) {
		Collection collection = new ArrayList();
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			Object next = iterator.next();
		}
	}
}
