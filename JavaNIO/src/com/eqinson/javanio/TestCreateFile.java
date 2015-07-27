package com.eqinson.javanio;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestCreateFile {
	public static void main(String[] args) throws IOException {
		Path file = Paths.get(System.getProperty("user.home"), "access2.log");
		try {
			// Create the empty file with default permissions, etc.
			Files.createFile(file);
		} catch (FileAlreadyExistsException x) {
			System.err.format("file named %s" + " already exists%n", file);
		} catch (IOException x) {
			// Some other sort of failure, such as permissions.
			System.err.format("createFile error: %s%n", x);
		}
		
		
		try {
		    Files.delete(file);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", file);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", file);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}

	}
}
