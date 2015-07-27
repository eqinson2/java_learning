/**
 * 
 */
package com.eqinson.javanio;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

/**
 * @author eqinson
 *
 */
public final class TestChannelIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Path p = Paths.get(System.getProperty("user.home"), "access.log");

		try (SeekableByteChannel sbc = Files.newByteChannel(p)) {
			ByteBuffer buf = ByteBuffer.allocate(10);

			// Read the bytes with the proper encoding for this platform. If
			// you skip this step, you might see something that looks like
			// Chinese characters when you expect Latin-style characters.
			String encoding = System.getProperty("file.encoding");
			while (sbc.read(buf) > 0) {
				buf.rewind();
				System.out.print(Charset.forName(encoding).decode(buf));
				buf.flip();
			}
		} catch (IOException x) {
			System.out.println("caught exception: " + x);

		}

		Set<OpenOption> options = new HashSet<OpenOption>();
		options.add(APPEND);
		options.add(CREATE);

		// Create the custom permissions attribute.
		Set<PosixFilePermission> perms = PosixFilePermissions
				.fromString("rw-r-----");
		FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions
				.asFileAttribute(perms);

		// Convert the string to a ByteBuffer.
		String s = "Hello World! ";
		byte data[] = s.getBytes();
		ByteBuffer bb = ByteBuffer.wrap(data);

		Path file = Paths.get("./permissions.log");

		try (SeekableByteChannel sbc = Files
				.newByteChannel(file, options, attr)) {
			sbc.write(bb);
		} catch (IOException x) {
			System.out.println("Exception thrown: " + x);
		}
	}
}
