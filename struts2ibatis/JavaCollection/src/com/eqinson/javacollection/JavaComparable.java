/**
 * 
 */
package com.eqinson.javacollection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author eqinson
 *
 */
public final class JavaComparable {

	private static class Name implements Comparable<Name> {
		private final String firstName, lastName;

		public Name(String firstName, String lastName) {
			if (firstName == null || lastName == null)
				throw new NullPointerException();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@SuppressWarnings("unused")
		public String firstName() {
			return firstName;
		}

		@SuppressWarnings("unused")
		public String lastName() {
			return lastName;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Name))
				return false;
			Name n = (Name) o;
			return n.firstName.equals(firstName) && n.lastName.equals(lastName);
		}

		public int hashCode() {
			return 31 * firstName.hashCode() + lastName.hashCode();
		}

		public String toString() {
			return firstName + " " + lastName;
		}

		public int compareTo(Name n) {
			int lastCmp = lastName.compareTo(n.lastName);
			return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Name nameArray[] = { new Name("John", "Smith"), new Name("Karl", "Ng"),
				new Name("Jeff", "Smith"), new Name("Tom", "Rich") };

		List<Name> names = Arrays.asList(nameArray);
		Collections.sort(names);
		System.out.println(names);

		names = Arrays.asList(nameArray);
		Set<Name> s = new TreeSet<Name>();
		for (Name n : names) {
			s.add(n);
		}

		for (Iterator<Name> it = s.iterator(); it.hasNext();)
			System.out.println(it.next());

	}

}
