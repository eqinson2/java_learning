/**
 * 
 */
package com.eqinson.javainnerclass;

/**
 * @author eqinson
 *
 */
public final class LocalInnerClass {
	// ˽�оֲ�
	private int i = 0;

	// ��̬
	public static int j = 0;

	// ����ֵ
	private final int k = 0;

	// static final
	private static final int m = 0;

	public static void test() {
		final int a = 0;
		int b = 0;
		// local inner class���ܹ��з��ʿ��Ʒ� ����public private
		abstract class LocalAbstractInnerClass {
			private int d = 0;
			abstract public void test();
		}
		
		new LocalAbstractInnerClass(){
			public void test(){
				// ���Է��ʷ������涨���final ����
				System.out.println(a);
				// ���ܷ���b ��Ϊb����final
				// System.out.println(b);
				// ������static�����������local inner class ���ܷ����ⲿ��ķ�static�ֶ�
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
				// �����ڷ�static�����ĵ�local inner class ���Է����ⲿ�����������
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
