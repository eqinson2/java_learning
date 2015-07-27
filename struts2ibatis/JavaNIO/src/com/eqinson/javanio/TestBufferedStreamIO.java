/**
 * 
 */
package com.eqinson.javanio;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.DELETE_ON_CLOSE;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author eqinson
 *
 */
public final class TestBufferedStreamIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Path file = Paths.get(System.getProperty("user.home"), "access.log");
		try (InputStream in = Files.newInputStream(file);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(in))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException x) {
			System.err.println(x);
		}

		String s = "Hello World! ";
		byte data[] = s.getBytes();
		Path p = Paths.get(System.getProperty("user.home"), "access2.log");

		try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(
				p, CREATE, APPEND,DELETE_ON_CLOSE))) {
			out.write(data, 0, data.length);
		} catch (IOException x) {
			System.err.println(x);
		}

	}

}
