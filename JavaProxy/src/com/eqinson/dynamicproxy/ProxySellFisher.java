package com.eqinson.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxySellFisher implements InvocationHandler {

	private SellFisher sell;

	public ProxySellFisher(SellFisher sell) {
		this.sell = sell;
	}

	public Object invoke(Object obj, Method method, Object[] args)
			throws Throwable {
		System.out.println("the fish price higher");
		return (Integer) method.invoke(sell, args) + 10;
	}

	public static void main(String args[]) {
		SellFisher s = new ConcreteSellFisher();
		InvocationHandler p = new ProxySellFisher(s);
		Object obj = Proxy.newProxyInstance(s.getClass().getClassLoader(), s
				.getClass().getInterfaces(), p);
		((SellFisher) obj).sellFish();
	}
}
