/**
 * 
 */
package com.eqinson.javainnerclass;

/**
 * @author eqinson
 *
 */
public final class LocalInnerClass {
	// 私有局部
	private int i = 0;

	// 静态
	public static int j = 0;

	// 不变值
	private final int k = 0;

	// static final
	private static final int m = 0;

	public static void test() {
		final int a = 0;
		int b = 0;
		// local inner class不能够有访问控制符 比如public private
		abstract class LocalAbstractInnerClass {
			private int d = 0;
			abstract public void test();
		}
		
		new LocalAbstractInnerClass(){
			public void test(){
				// 可以访问方法里面定义的final 变量
				System.out.println(a);
				// 不能访问b 因为b不是final
				// System.out.println(b);
				// 定义在static上下文里面的local inner class 不能访问外部类的非static字段
				// System.out.println(i);
				// System.out.println(k);
				System.out.println(j);
				System.out.println(m);
			}
		}.test();
	}

	public void test2() {
		final int a = 0;
		int b = 0;
		final class LocalNonStaticInnerClass {
			public LocalNonStaticInnerClass() {
				// 定义在非static上下文的local inner class 可以访问外部类的所有属性
			}

			public void test() {
				System.out.println(i);
				System.out.println(k);
				System.out.println(j);
				System.out.println(m);
			}
		}

		new LocalNonStaticInnerClass().test();
	}
}
