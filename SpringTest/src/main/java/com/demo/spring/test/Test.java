package com.demo.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"WebContent/WEB-INF/applicationContext.xml");
		HelloWorld hello = (HelloWorld) ctx.getBean("HelloWorld");
		System.out.println(hello.execute("World"));
	}
}
