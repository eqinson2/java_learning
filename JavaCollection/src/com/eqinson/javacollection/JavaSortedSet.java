/**
 * 
 */
package com.eqinson.javacollection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author eqinson
 *
 */
public final class JavaSortedSet {

	private static class People {
		String name;
		int id;
		int age;

		public People(String name, int id, int age) {
			this.name = name;
			this.id = id;
			this.age = age;
		}

		public String toString() {
			return id + " " + " " + name + " " + age;
		}
	}

	private static class PeopleComparator implements Comparator<People> {
		@Override
		public int compare(People p0, People p1) {
			if (p0 == p1)
				return 0;
			if (p0 != null && p1 == null)
				return 1;
			else if (p0 == null && p1 != null)
				return -1;
			if (p0.id > p1.id)
				return 1;
			else if (p0.id < p1.id)
				return -1;
			else
				return 0;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PeopleComparator comparator = new PeopleComparator();
		TreeSet<People> set = new TreeSet<People>(comparator);
		set.add(new People("robin", 1, 21));
		set.add(new People("hb", 2, 20));
		set.add(new People("harry", 9, 30));
		set.add(null);
		set.add(new People("robin", 4, 25));
		set.add(new People("yp", 5, 28));
		set.add(new People("yp2", 8, 28));
		for (People p : set)
			System.out.println(p);

	}

}
