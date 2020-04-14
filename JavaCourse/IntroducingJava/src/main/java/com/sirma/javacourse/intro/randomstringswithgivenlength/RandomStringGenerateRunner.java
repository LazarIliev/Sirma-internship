package com.sirma.javacourse.intro.randomstringswithgivenlength;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is class runner for RandomString class.
 */
public class RandomStringGenerateRunner {
	private static final Logger logger = LoggerFactory.getLogger(RandomStringGenerateRunner.class);

	/**
	 * Initialize and declare integer value. Initialize RandomString class.
	 * Pass the integer value to RandomString's method for getAlphaNumericString to get random string generated.
	 */
	public static void main(String[] args) {
		int length = 23;

		logger.info(RandomStringGenerator.getAlphaNumericString(length));
	}
}
