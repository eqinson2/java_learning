/**
 * 
 */
package com.eqinson.generic;

import java.util.Queue;

/**
 * @author eqinson
 *
 */
class Lhist<V extends Queue<String>> {
	private Object[] array;
	private int size;

	public Lhist(int capacity) {
		array = new Object[capacity];
	}

	public void add(V value) {
		if (size == array.length)
			throw new IndexOutOfBoundsException(Integer.toString(size));
		else if (value == null)
			throw new NullPointerException();
		array[size++] = value;
	}

	public void remove(V value) {
		int removalCount = 0;
		for (int i = 0; i < size; i++) {
			if (array[i].equals(value))
				++removalCount;
			else if (removalCount > 0) {
				array[i - removalCount] = array[i];
				array[i] = null;
			}
		}
		size -= removalCount;
	}

	public int size() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public V get(int i) {
		if (i >= size)
			throw new IndexOutOfBoundsException(Integer.toString(i));
		return (V) array[i];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Lhist<String> ls = new Lhist<String>(30);
		Lhist<Queue<String>> li = new Lhist<Queue<String>>(30);
	}

}