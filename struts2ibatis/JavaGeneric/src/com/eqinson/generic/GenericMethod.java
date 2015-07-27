/**
 * 
 */
package com.eqinson.generic;

/**
 * @author eqinson
 *
 */
public final class GenericMethod {

	public static <T> T ifThenElse(boolean b, T first, T second) {
		return b ? first : second;
	}

	public <T> T ifThenElse2(boolean b, T first, T second) {
		return b ? first : second;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = ifThenElse(true, "a", "b");
		Integer i = ifThenElse(false, new Integer(1), new Integer(2));
		Float ss = ifThenElse(false, new Float(3.141), new Float(3.14));

		System.out.println(s);
		System.out.println(i);
		System.out.println(ss.floatValue());

		new GenericMethod().ifThenElse2(true, new Integer(1), new Integer(2));
	}

}
