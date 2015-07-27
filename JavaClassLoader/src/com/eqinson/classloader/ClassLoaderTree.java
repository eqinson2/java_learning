/**
 * 
 */
package com.eqinson.classloader;

/**
 * @author eqinson
 *
 */
public final class ClassLoaderTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTree.class.getClassLoader();
		while (loader != null) {
			System.out.println(loader.toString());
			loader = loader.getParent();

		}
	}
}
