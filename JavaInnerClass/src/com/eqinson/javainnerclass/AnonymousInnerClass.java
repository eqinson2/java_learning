package com.eqinson.javainnerclass;

public final class AnonymousInnerClass {
	// ���ʹ���;ֲ���һ��
	public void test() {

		// ������ʵ��
		new Thread(new Runnable() {
			@Override
			public void run() {

			}
		}).start();

		// ��������ʵ��
		class NoneAnonymousClass implements Runnable {
			public void run() {

			}
		}
		NoneAnonymousClass t = new NoneAnonymousClass();
		new Thread(t).start();
	}
}
