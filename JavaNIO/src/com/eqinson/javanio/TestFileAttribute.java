/**
 * 
 */
package com.eqinson.javanio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * @author eqinson
 *
 */
public final class TestFileAttribute {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Path file = Paths.get(System.getProperty("user.home"), "access.log");

		BasicFileAttributes attr = Files.readAttributes(file,
				BasicFileAttributes.class);

		System.out.println("creationTime: " + attr.creationTime());
		System.out.println("lastAccessTime: " + attr.lastAccessTime());
		System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

		System.out.println("isDirectory: " + attr.isDirectory());
		System.out.println("isOther: " + attr.isOther());
		System.out.println("isRegularFile: " + attr.isRegularFile());
		System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
		System.out.println("size: " + attr.size());

		long currentTime = System.currentTimeMillis();
		FileTime ft = FileTime.fromMillis(currentTime);
		Files.setLastModifiedTime(file, ft);

	}

}
