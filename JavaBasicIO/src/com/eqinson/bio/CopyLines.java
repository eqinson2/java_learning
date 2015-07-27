package com.eqinson.bio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class CopyLines {

	public static void main(String[] args) throws IOException {
		BufferedReader inputStream = null;
		BufferedWriter outputStream = null;
		// PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader("xanadu.txt"));
			outputStream = new BufferedWriter(new FileWriter(
					"characteroutput.txt"));

			String l;
			while ((l = inputStream.readLine()) != null) {
				outputStream.write(l);
			}
			outputStream.flush();
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
