package com.eqinson.fork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Farther {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {
		// ִ�г���
		Process process = Runtime.getRuntime().exec(
				"java -cp d:/java/child.jar; com.xie.netcourse3.Child");
		
		// ������Ϣ
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				process.getOutputStream()));
		bw.write("I am your farther");
		bw.flush();
		// ����رղ����յ���Ϣ
		bw.close();
		// ��ȡ���򷵻���Ϣ

		BufferedReader br = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		String line = null;
		StringBuffer all = new StringBuffer();
		while ((line = br.readLine()) != null) {
			all.append(line);
		}
		br.close();
		// ��ʾ������Ϣ
		System.out.println("farther receive:" + all.toString());
	}
}
