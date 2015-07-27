/**
 * 
 */
package com.eqinson.javacollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @author eqinson
 *
 */
public final class JavaList {

	public static void Shuffle() {
		String[] array = { "i", "came", "i", "saw", "i", "left" };
		List<String> list = Arrays.asList(array);
		Collections.shuffle(list);
		System.out.println(list);
	}

	public static void reverseTraverse() {
		String[] array = { "i", "came", "i", "saw", "i", "left" };
		List<String> list = Arrays.asList(array);
		for (ListIterator<String> it = list.listIterator(list.size()); it
				.hasPrevious();) {
			System.out.format("%s   ", it.previous());
		}

		System.out.println();

		for (ListIterator<String> it = list.listIterator(); it.hasNext();) {
			System.out.format("%s   ", it.next());
		}

		System.out.println();
	}

	public static int indexOf() {
		String[] array = { "i", "came", "i", "saw", "i", "left" };
		String e = "saw";
		List<String> list = Arrays.asList(array);
		for (ListIterator<String> it = list.listIterator(); it.hasNext();) {
			if (e == null ? it.next() == null : e.equals(it.next()))
				return it.previousIndex();
		}
		// Element not found
		return -1;
	}

	public static void replace() {
		String[] array = { "i", "came", "i", "saw", "i", "left" };
		String e = "saw";
		List<String> list = Arrays.asList(array);
		for (ListIterator<String> it = list.listIterator(); it.hasNext();)
			if (e == null ? it.next() == null : e.equals(it.next()))
				it.set("SAW");

		for (String s : list)
			System.out.format("%s   ", s);

		System.out.println();
	}

	public static void replaceAndInsert() {
		String[] array = { "i", "came", "i", "saw", "i", "left" };
		String e = "i";
		List<String> list = new ArrayList<String>(Arrays.asList(array));

		String[] array2 = { "song", "qing", "wei" };
		List<String> newVals = Arrays.asList(array2);

		for (ListIterator<String> it = list.listIterator(); it.hasNext();) {
			if (e == null ? it.next() == null : e.equals(it.next())) {
				it.remove();
				for (String ee : newVals)
					it.add(ee);
			}
		}

		for (String s : list)
			System.out.format("%s   ", s);
	}

	public static void RangeView() {
		String[] array = { "i", "came", "i", "saw", "i", "left" };
		List<String> list = Arrays.asList(array);

		int i = list.subList(0, 3).indexOf("came");
		int j = list.subList(3, 6).lastIndexOf("left");
		System.out.println();
		System.out.format("%d	%d", i, j);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Shuffle();
		reverseTraverse();
		System.out.println(indexOf());
		replace();
		replaceAndInsert();
		RangeView();
	}

}
