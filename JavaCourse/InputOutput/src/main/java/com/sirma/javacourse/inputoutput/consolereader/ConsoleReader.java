package com.sirma.javacourse.inputoutput.consolereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Holds methods for reading Integer, Float, String and Character from an {@link InputStream}.
 */
class ConsoleReader {

	/**
	 * Protects from instantiation.
	 */
	private ConsoleReader() {

	}

	/**
	 * Reading a string for testing purposes from a custom {@link InputStream}.
	 *
	 * @param in the custom {@link InputStream}.
	 * @return the red string.
	 * @throws IOException if  {@link InputStream} is not correct.
	 */
	static String readString(InputStream in) throws IOException {
		return createBufferReader(in);
	}

	/**
	 * Reading an integer from a custom {@link InputStream}.
	 * Throws IOException if  {@link InputStream} is not correct.
	 *
	 * @param in the custom {@link InputStream}.
	 * @return the red integer.
	 */
	static int readInt(InputStream in) throws IOException {
		String res = createBufferReader(in);
		return Integer.parseInt(res);
	}

	/**
	 * Reading a float from a custom {@link InputStream}.
	 * Throws IOException if  {@link InputStream} is not correct.
	 *
	 * @param in the custom {@link InputStream}.
	 * @return char value of the read input.
	 */
	static char readChar(InputStream in) throws IOException {
		String res = createBufferReader(in);
		return res.charAt(0);
	}

	/**
	 * Reading a float from a custom {@link InputStream}.
	 * Throws IOException if  {@link InputStream} is not correct.
	 *
	 * @param in the custom {@link InputStream}.
	 * @return the red float.
	 */
	static float readFloat(InputStream in) throws IOException {
		String res = createBufferReader(in);
		return Float.parseFloat(res);
	}

	private static String createBufferReader(InputStream in) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
			return reader.readLine();
		}
	}
}
