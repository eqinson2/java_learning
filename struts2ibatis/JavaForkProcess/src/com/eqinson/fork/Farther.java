package com.eqinson.fork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Farther {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {
		// 执行程序
		Process process = Runtime.getRuntime().exec(
				"java -cp d:/java/child.jar; com.xie.netcourse3.Child");
		
		// 发送消息
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				process.getOutputStream()));
		bw.write("I am your farther");
		bw.flush();
		// 必须关闭才能收到信息
		bw.close();
		// 读取程序返回消息

		BufferedReader br = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		String line = null;
		StringBuffer all = new StringBuffer();
		while ((line = br.readLine()) != null) {
			all.append(line);
		}
		br.close();
		// 显示返回消息
		System.out.println("farther receive:" + all.toString());
	}
}
