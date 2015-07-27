/**
 * 
 */
package com.eqinson.javainnerclass;

/**
 * @author eqinson
 *
 */
public final class MemberInnerClass {
	// 私有局部
	public int i = 0;

	// 静态
	private static int j = 0;

	// 不变值
	private final int k = 0;

	// static final
	private static final int m = 0;

	public class PublicMemberInnerClass {
		// enclosing Class的属性都可以访问
		public void test() {
			System.out.println(i);
			System.out.println(j);
			System.out.println(m);
			System.out.println(k);
		}

		public MemberInnerClass getOutterClass() {
			return MemberInnerClass.this;
		}
		// 这里会报错，不允许定义static方法
		// private static final void test2()
		// {
		//
		// }
	}

	// 私有的innerclass 外部不能访问
	private class PrivateMemberInnerClass {
		// enclosing Class的属性都可以访问
		public void test() {
			System.out.println(i);
			System.out.println(j);
			System.out.println(m);
			System.out.println(k);
		}

		public MemberInnerClass getOutterClass() {
			return MemberInnerClass.this;
		}
		// 这里会报错，不允许定义static方法
		// private static final void test2()
		// {
		//
		// }
	}

	// 公开局部类，外部可以访问和创建，但是只能通过OutterClass实例创建
	class DefaultMemberInnerClass {

		// enclosing Class的属性都可以访问
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
