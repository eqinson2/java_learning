/**
 * 
 */
package com.eqinson.javanio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

/**
 * @author eqinson
 *
 */
public final class TestSmallFile {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Path file = Paths.get(System.getProperty("user.home"), "access.log");
		byte[] fileArray;
		fileArray = Files.readAllBytes(file);
		String str = new String(fileArray, "UTF-8");
		System.out.print(str);

		Path file2 = Paths.get(System.getProperty("user.home"), "access2.log");
		Files.write(file2, fileArray, WRITE, CREATE, DELETE_ON_CLOSE);

	}

}
