package com.eqinson.javainnerclass;

public class StaticNestedClass {

	// 私有局部
	private int i = 0;

	// 静态
	public static int j = 0;

	// 不变值
	private final int k = 0;

	// static final
	private static final int m = 0;

	// 静态嵌套内，这里不是innerclass,可以直接new出来
	public static class PublicNestedClass {

		public void test1() {
			// System.out.println(i); 非innerClass不能访问enclosing类的非static属性
			System.out.println(j);
			System.out.println(m);
			// System.out.println(k); 非innerClass不能访问enclosing类的非static属性
		}

		// 可以定义static方法
		private static void test2() {

		}
	}

	// 静态嵌套内，这里不是innerclass,由于是私有的，不可以直接new出来
	static class DefaultNestedClass {

		public void test1() {
			// System.out.println(i); 非innerClass不能访问enclosing类的非static属性
			System.out.println(j);
			System.out.println(m);
			// System.out.println(k); 非innerClass不能访问enclosing类的非static属性
		}

		// 可以定义static方法
		private static void test2() {

		}
	}

	// 静态嵌套内，这里不是innerclass,由于是私有的，不可以直接new出来
	private static class PrivateNestedClass {

		public void test1() {
			// System.out.println(i); 非innerClass不能访问enclosing类的非static属性
			System.out.println(j);
			System.out.println(m);
			// System.out.println(k); 非innerClass不能访问enclosing类的非static属性
		}

		// 可以定义static方法
		private static void test2() {

		}
	}
}