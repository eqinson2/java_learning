/**
 * 
 */
package com.eqinson.javacollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author eqinson
 *
 */
public final class JavaQueue {
	public static void Countdown() throws InterruptedException {
		int time = 10;
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = time; i >= 0; i--)
			queue.add(i);

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
			Thread.sleep(10);
		}
	}

	public static <E> List<E> heapSort(Collection<E> c) {
		Queue<E> queue = new PriorityQueue<E>(c);
		List<E> result = new ArrayList<E>();

		while (!queue.isEmpty())
			result.add(queue.remove());

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Countdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Integer> list = Arrays.asList( 3, 2, 4, 1, 6, 7, 10 );
		System.out.println(heapSort(list));

	}

}
