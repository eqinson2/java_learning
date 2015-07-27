/**
 * 
 */
package com.eqinson.javacollection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author eqinson
 *
 */
public final class JavaMultiMap {

	public static void main(String[] args) {
		int minGroupSize = Integer.parseInt(args[1]);

		// Read words from file and put into a simulated multimap
		Map<String, List<String>> m = new HashMap<String, List<String>>();

		try (Scanner s = new Scanner(new File(args[0]))) {
			while (s.hasNext()) {
				String word = s.next();
				String alpha = alphabetize(word);
				List<String> l = m.get(alpha);
				if (l == null)
					m.put(alpha, l = new ArrayList<String>());
				l.add(word);
			}
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}

		// Print all permutation groups above size threshold
		for (List<String> l : m.values())
			if (l.size() >= minGroupSize)
				System.out.println(l.size() + ": " + l);
	}

	private static String alphabetize(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}

}
