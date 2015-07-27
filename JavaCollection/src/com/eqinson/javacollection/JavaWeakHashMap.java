/**
 * 
 */
package com.eqinson.javacollection;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * @author eqinson
 *
 */
public final class JavaWeakHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();

		for (int i = 0; i < 1000; i++) {
			WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
			d.put(new byte[1000][1000], new byte[1000][1000]);
			maps.add(d);
			System.gc();
			System.err.println(i);
		}
	}

}
