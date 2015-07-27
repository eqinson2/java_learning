/**
 * 
 */
package com.eqinson.javacollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author eqinson
 *
 */
public final class JavaMap {

	public static <K, V> boolean validate(Map<K, V> attrMap,
			Set<K> requiredAttrs, Set<K> permittedAttrs) {
		boolean valid = true;
		Set<K> attrs = attrMap.keySet();

		if (!attrs.containsAll(requiredAttrs)) {
			Set<K> missing = new HashSet<K>(requiredAttrs);
			missing.removeAll(attrs);
			System.out.println("Missing attributes: " + missing);
			valid = false;
		}
		if (!permittedAttrs.containsAll(attrs)) {
			Set<K> illegal = new HashSet<K>(attrs);
			illegal.removeAll(permittedAttrs);
			System.out.println("Illegal attributes: " + illegal);
			valid = false;
		}
		return valid;
	}

	public static void Freq(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();

		// Initialize frequency table from command line
		for (String a : args) {
			Integer freq = m.get(a);
			m.put(a, (freq == null) ? 1 : freq + 1);
		}

		System.out.println(m.size() + " distinct words:");
		System.out.println(m);

		for (String key : m.keySet())
			System.out.format("%s ", key);

		System.out.println();

		for (Iterator<String> it = m.keySet().iterator(); it.hasNext();)
			if (it.next().equals("if"))
				it.remove();
		System.out.println(m);

		for (Integer value : m.values())
			System.out.format("%d ", value);

		for (Map.Entry<String, Integer> e : m.entrySet())
			System.out.println(e.getKey() + ": " + e.getValue());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] a = { "if", "it", "is", "to", "be", "it", "is", "up", "to",
				"me", "to", "delegate" };
		Freq(a);
	}
}
