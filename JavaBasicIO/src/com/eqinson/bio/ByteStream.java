/**
 * 
 */
package com.eqinson.bio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author eqinson
 *
 */
public final class ByteStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("xanadu_zh.txt");
            out = new FileOutputStream("outagain_zh.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
