/**
 * 
 */
package com.eqinson.reflection;

/**
 * @author eqinson
 *
 */

abstract class Cls {
	public Cls() {
	}
}

public final class BasicOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("com.eqinson.reflection.Cls");
			c.newInstance(); // InstantiationException

			// production code should handle these exceptions more gracefully
		} catch (InstantiationException x) {
			x.printStackTrace();
		} catch (IllegalAccessException x) {
			x.printStackTrace();
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}

}
