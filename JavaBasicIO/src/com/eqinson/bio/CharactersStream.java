/**
 * 
 */
package com.eqinson.bio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author eqinson
 *
 */
public final class CharactersStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

		FileReader inputStream = null;
		FileWriter outputStream = null;

		try {
			inputStream = new FileReader("xanadu_zh.txt");
			outputStream = new FileWriter("characteroutput_zh.txt");
			/*
			 * in CopyCharacters, the int variable holds a character value in
			 * its last 16 bits; in CopyBytes, the int variable holds a byte
			 * value in its last 8 bits.
			 */
			int c;
			while ((c = inputStream.read()) != -1) {
				outputStream.write(c);
			}
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
