package com.eqinson.javainnerclass;

public class StaticNestedClass {

	// ˽�оֲ�
	private int i = 0;

	// ��̬
	public static int j = 0;

	// ����ֵ
	private final int k = 0;

	// static final
	private static final int m = 0;

	// ��̬Ƕ���ڣ����ﲻ��innerclass,����ֱ��new����
	public static class PublicNestedClass {

		public void test1() {
			// System.out.println(i); ��innerClass���ܷ���enclosing��ķ�static����
			System.out.println(j);
			System.out.println(m);
			// System.out.println(k); ��innerClass���ܷ���enclosing��ķ�static����
		}

		// ���Զ���static����
		private static void test2() {

		}
	}

	// ��̬Ƕ���ڣ����ﲻ��innerclass,������˽�еģ�������ֱ��new����
	static class DefaultNestedClass {

		public void test1() {
			// System.out.println(i); ��innerClass���ܷ���enclosing��ķ�static����
			System.out.println(j);
			System.out.println(m);
			// System.out.println(k); ��innerClass���ܷ���enclosing��ķ�static����
		}

		// ���Զ���static����
		private static void test2() {

		}
	}

	// ��̬Ƕ���ڣ����ﲻ��innerclass,������˽�еģ�������ֱ��new����
	private static class PrivateNestedClass {

		public void test1() {
			// System.out.println(i); ��innerClass���ܷ���enclosing��ķ�static����
			System.out.println(j);
			System.out.println(m);
			// System.out.println(k); ��innerClass���ܷ���enclosing��ķ�static����
		}

		// ���Զ���static����
		private static void test2() {

		}
	}
}