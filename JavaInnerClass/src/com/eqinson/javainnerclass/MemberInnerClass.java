/**
 * 
 */
package com.eqinson.javainnerclass;

/**
 * @author eqinson
 *
 */
public final class MemberInnerClass {
	// ˽�оֲ�
	public int i = 0;

	// ��̬
	private static int j = 0;

	// ����ֵ
	private final int k = 0;

	// static final
	private static final int m = 0;

	public class PublicMemberInnerClass {
		// enclosing Class�����Զ����Է���
		public void test() {
			System.out.println(i);
			System.out.println(j);
			System.out.println(m);
			System.out.println(k);
		}

		public MemberInnerClass getOutterClass() {
			return MemberInnerClass.this;
		}
		// ����ᱨ����������static����
		// private static final void test2()
		// {
		//
		// }
	}

	// ˽�е�innerclass �ⲿ���ܷ���
	private class PrivateMemberInnerClass {
		// enclosing Class�����Զ����Է���
		public void test() {
			System.out.println(i);
			System.out.println(j);
			System.out.println(m);
			System.out.println(k);
		}

		public MemberInnerClass getOutterClass() {
			return MemberInnerClass.this;
		}
		// ����ᱨ����������static����
		// private static final void test2()
		// {
		//
		// }
	}

	// �����ֲ��࣬�ⲿ���Է��ʺʹ���������ֻ��ͨ��OutterClassʵ������
	class DefaultMemberInnerClass {

		// enclosing Class�����Զ����Է���
		public void test() {
			System.out.println(i);
			System.out.println(j);
			System.out.println(m);
			System.out.println(k);
		}

		public MemberInnerClass getOutterClass() {
			return MemberInnerClass.this;
		}
	}
}
