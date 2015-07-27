/**
 * 
 */
package com.eqinson.javanio;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author eqinson
 *
 */
public final class TestFileCpMvDel {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Path source = Paths.get(System.getProperty("user.home"), "access.log");
		Path target_cp = Paths.get(System.getProperty("user.home"), "access_cp.log");
		Path target_mv = Paths.get(System.getProperty("user.home"), "access_mv.log");
		
		Files.copy(source, target_cp, REPLACE_EXISTING);
		Files.move(target_cp, target_mv, REPLACE_EXISTING);
		
		try {
		    Files.delete(target_mv);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", target_mv);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", target_mv);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}

	}

}
