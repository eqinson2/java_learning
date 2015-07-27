package com.eqinson.javainnerclass;

public final class TestClass {

	public static void main(String[] args) {
		/* ======================static inner class======================== */
		// �κεط������Դ���
		StaticNestedClass.PublicNestedClass publicNestedClass = new StaticNestedClass.PublicNestedClass();

		// ������ͬһpackage�´���
		StaticNestedClass.DefaultNestedClass defaultNestedClass = new StaticNestedClass.DefaultNestedClass();
		// ��������޷������ڲ���
		// StaticNestedClass.PrivateNestedClass privateNestedClass = new
		// StaticNestedClass.PrivateNestedClass();
		
		publicNestedClass.test1();
		defaultNestedClass.test1();
		
		/* ======================member inner class======================== */
		// �κεط������Դ���
		MemberInnerClass t = new MemberInnerClass();

		// ���Դ�����pmic���汣���t������
		MemberInnerClass.PublicMemberInnerClass pmic = t.new PublicMemberInnerClass();

		// ������ͬһpackage�´�����dmic�����t������
		MemberInnerClass.DefaultMemberInnerClass dmic = t.new DefaultMemberInnerClass();

		// ��������޷������ڲ���
		// MemberInnerClass.PrivateMemberInnerClass pmic = t.new
		// PrivateMemberInnerClass();

		// ������֤һ��outterClass��ͬһ������
		System.out.println(pmic.getOutterClass() == t);
		System.out.println(dmic.getOutterClass() == t);
		
		/* ======================local inner class======================== */
		LocalInnerClass.test();
		new LocalInnerClass().test2();
		
		/* ======================Anonymous inner class======================== */
		new AnonymousInnerClass().test();
	}

}
