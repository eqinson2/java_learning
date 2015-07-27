package com.eqinson.classloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ContextClassLoaderTest {
	public static void main(String[] args) throws MalformedURLException,
			ClassNotFoundException {
		System.out.println("MainClass getClassLoader: "
				+ ContextClassLoaderTest.class.getClassLoader());
		System.out.println("MainClass getContextClassLoader: "
				+ Thread.currentThread().getContextClassLoader());
		Thread innerThread1 = new InnerThread1();
		innerThread1.start();
	}
}

class InnerThread1 extends Thread {
	@Override
	public void run() {
		try {
			URL[] urls = new URL[1];
			urls[0] = new URL(
					"jar:file:/C:/maworkspace/java_learning/JavaClassLoader/junit-4.11.jar!/");
			URLClassLoader urlClassLoader = new URLClassLoader(urls);
			Class<?> clazz = urlClassLoader.loadClass("junit.runner.Version");

			System.out.println("InnerThread1 getClassLoader: "
					+ clazz.getClassLoader());
			System.out.println("InnerThread1 getContextClassLoader: "
					+ Thread.currentThread().getContextClassLoader());

			this.setContextClassLoader(urlClassLoader);

			Thread innerThread2 = new InnerThread2();
			innerThread2.start();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class InnerThread2 extends Thread {
	@Override
	public void run() {
		try {
			ClassLoader classLoader = Thread.currentThread()
					.getContextClassLoader();
			classLoader.loadClass("junit.runner.Version");
			System.out.println("InnerThread2 getContextClassLoader: "
					+ Thread.currentThread().getContextClassLoader());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
