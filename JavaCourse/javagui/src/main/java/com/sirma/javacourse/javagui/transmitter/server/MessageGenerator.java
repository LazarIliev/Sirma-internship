package com.sirma.javacourse.javagui.transmitter.server;

import java.util.Random;

/**
 * Holds methods for generating messages.
 */
public class MessageGenerator {
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int STRING_SIZE = 5;
	private Random randomGenerator = new Random();

	/**
	 * Generates and returns a string.
	 *
	 * @return random string
	 */
	public String generateString() {
		StringBuilder generatedString = new StringBuilder(STRING_SIZE);

		for (int i = 0; i < STRING_SIZE; i++) {
			int randomNumber = randomGenerator.nextInt(STRING_SIZE);
			char randomChar = CHARACTERS.charAt(randomNumber);
			generatedString.append(randomChar);
		}

		return generatedString.toString();
	}

	/**
	 * Generates and returns an integer number.
	 *
	 * @return random integer number
	 */
	public String generateInt() {
		return Integer.toString(randomGenerator.nextInt());
	}
}
