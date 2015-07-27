package com.eqinson.javainnerclass;

public final class AnonymousInnerClass {
	// 访问规则和局部类一样
	public void test() {

		// 匿名类实现
		new Thread(new Runnable() {
			@Override
			public void run() {

			}
		}).start();

		// 非匿名类实现
		class NoneAnonymousClass implements Runnable {
			public void run() {

			}
		}
		NoneAnonymousClass t = new NoneAnonymousClass();
		new Thread(t).start();
	}
}
