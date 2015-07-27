/**
 * 
 */
package com.eqinson.javanio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author eqinson
 *
 */
public final class TestPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ���path����һ,c:/ex/access.log
		Path path = FileSystems.getDefault().getPath("C:/Users/eqinson",
				"access.log");
		System.out.println(path.getNameCount());

		// ���path����������File��toPath()�������Path����
		File file = new File("C:/Users/eqinson/access.log");
		Path pathOther = file.toPath();
		// 0,˵��������path����ȵ�
		System.out.println(path.compareTo(pathOther));
		// ���path������
		Path path3 = Paths.get(System.getProperty("user.home"), "access.log");
		System.out.println(path3.toString());

		System.out.format("toString: %s%n", path3.toString());
		System.out.format("getFileName: %s%n", path3.getFileName());
		System.out.format("getName(0): %s%n", path3.getName(0));
		System.out.format("getNameCount: %d%n", path3.getNameCount());
		System.out.format("subpath(0,2): %s%n", path3.subpath(0, 2));
		System.out.format("getParent: %s%n", path3.getParent());
		System.out.format("getRoot: %s%n", path3.getRoot());

		try {
			if (Files.isReadable(path3)) {
				// ע��˴���newBufferedRead��charset�������������Ҫ��ȡ���ļ��ı��벻һ�£�����׳��쳣
				// java�������ԣ������Լ��ر���
				BufferedReader br = Files.newBufferedReader(path3,
						Charset.defaultCharset());
				// new BufferedReader(new FileReader(new
				// File("e:/logs/access.log")));//
				String line = "";
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} else {
				System.err.println("not readable");
			}
		} catch (IOException e) {
			System.err.println("error charset");
		}

		Path inputPath = Paths.get("access.log");
		Path fullPath = inputPath.toAbsolutePath();
		System.out.format("toString: %s%n", fullPath.toString());

		// =====================================================
		// Microsoft Windows
		Path p1 = Paths.get("C:/Users/eqinson/foo");
		System.out.format("%s%n", p1.resolve("bar"));

		Charset charset = Charset.forName("US-ASCII");
		String s = "wwwwwwwwwwwwwwwwwwwwwwwwww";

		if (Files.isRegularFile(p1)
				& (Files.isReadable(p1) || Files.isWritable(p1))) {
			try (BufferedWriter writer = Files.newBufferedWriter(p1, charset)) {
				writer.write(s, 0, s.length());
			} catch (IOException x) {
				System.err.format("IOException: %s%n", x);
			}
		}
	}
}
