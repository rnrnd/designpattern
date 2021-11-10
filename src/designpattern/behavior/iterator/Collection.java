package designpattern.behavior.iterator;

public interface Collection<E> extends Iterable {
	int size();
	boolean isEmpty();
	boolean contains(Object o);
	boolean add(E e);
	boolean remove(Object o);
	Iterator iterator();
}
