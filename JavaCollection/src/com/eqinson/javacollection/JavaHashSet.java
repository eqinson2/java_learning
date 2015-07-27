/**
 * 
 */
package com.eqinson.javacollection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author eqinson
 *
 */
public final class JavaHashSet {

	public static void FindDups() {
		String[] array = { "i", "came", "i", "saw", "i", "left" };
		Set<String> s = new HashSet<String>();
		for (String a : array)
			s.add(a);
		System.out.println(s.size() + " distinct words: " + s);
	}

	public static void FindDups2() {
		String[] array = { "i", "came", "i", "saw", "i", "left" };
		Set<String> uniques = new HashSet<String>();
		Set<String> dups = new HashSet<String>();

		for (String a : array)
			if (!uniques.add(a))
				dups.add(a);

		// Destructive set-difference
		uniques.removeAll(dups);

		System.out.println("Unique words:    " + uniques);
		System.out.println("Duplicate words: " + dups);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FindDups();
		FindDups2();
	}

}
