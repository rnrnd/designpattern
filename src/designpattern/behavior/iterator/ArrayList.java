package designpattern.behavior.iterator;

import java.util.Arrays;

public class ArrayList<E> implements Collection<E>{
	private final int defaultcapacity = 10;
	private Object[] elementData;
	private int size;
	public ArrayList(){
		elementData = new Object[defaultcapacity];
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean add(E e) {
		if (size >=elementData.length) {
			int newCapacity;
			if (size <= defaultcapacity) {
				newCapacity = size + defaultcapacity>>1;
			} else {
				newCapacity = size + size>>1;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
		return false;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public Iterator iterator() {
		return new ArrayListIterator();
	}
	private class ArrayListIterator<E> implements Iterator<E> {
		int cursor;
		@Override
		public boolean hasNext() {
			return cursor == size;
		}

		@Override
		public E next() {
			return null;
		}

	}
}
