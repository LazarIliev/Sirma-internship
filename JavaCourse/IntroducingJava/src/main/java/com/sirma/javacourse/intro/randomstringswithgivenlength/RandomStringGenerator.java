package com.sirma.javacourse.intro.randomstringswithgivenlength;

import java.security.InvalidParameterException;

/**
 * RandomString class to generate random string by given length by his method getAlphaNumericString.
 */
class RandomStringGenerator {

	private static final int MAX_RANGE = 122;
	private static final int MIN_RANGE = 48;
	private static final int END_OF_NUMBERS_INDEX = 57;
	private static final int START_OF_UPPERCASE_LETTERS_INDEX = 65;
	private static final int END_OF_UPPERCASE_LETTERS_INDEX = 90;
	private static final int START_OF_LOWERCASE_LETTER_INDEX = 97;

	RandomStringGenerator() {
	}

	/**
	 * Initialize and declare a string form which on a random principal characters one by one  will be chosen
	 * for the new string until the given length is reached.
	 *
	 * @param length integer value of the length that the generated string should have.
	 * @return string value of the random generated string.
	 */
	static String getAlphaNumericString(int length) {
		if (length <= 0) {
			throw new InvalidParameterException("Length should be a positive number!");
		}

		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * ((MAX_RANGE - MIN_RANGE) + 1)) + MIN_RANGE;

			if ((index > END_OF_NUMBERS_INDEX && index < START_OF_UPPERCASE_LETTERS_INDEX) || (
					index > END_OF_UPPERCASE_LETTERS_INDEX && index < START_OF_LOWERCASE_LETTER_INDEX)) {
				i--;
				continue;
			}

			// add Character one by one in end of sb
			sb.append((char) index);
		}
		return sb.toString();
	}
}
