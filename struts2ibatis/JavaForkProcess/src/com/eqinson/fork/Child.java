package com.eqinson.fork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Child {
	public static void main(String[] args) throws IOException {
		// 准备接收父程序消息
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		StringBuffer all = new StringBuffer();

		// 接收父程序消息
		while ((line = s.readLine()) != null) {
			all.append(line);
		}
		System.out.println("child receive:" + all.toString() + "/n");
		s.close();
		// 当父程序关闭输入流时，执行操作
		String ret = "I am your son";
		// 返回消息给父程序
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		bw.write(ret);
		bw.flush();
		bw.close();
	}
}
