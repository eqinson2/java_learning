package com.eqinson.fork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Child {
	public static void main(String[] args) throws IOException {
		// ׼�����ո�������Ϣ
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		StringBuffer all = new StringBuffer();

		// ���ո�������Ϣ
		while ((line = s.readLine()) != null) {
			all.append(line);
		}
		System.out.println("child receive:" + all.toString() + "/n");
		s.close();
		// ��������ر�������ʱ��ִ�в���
		String ret = "I am your son";
		// ������Ϣ��������
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		bw.write(ret);
		bw.flush();
		bw.close();
	}
}
