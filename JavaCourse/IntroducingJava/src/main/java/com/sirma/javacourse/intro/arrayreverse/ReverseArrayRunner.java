package com.sirma.javacourse.intro.arrayreverse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a runner class.
 */
public class ReverseArrayRunner {
	private static final Logger logger = LoggerFactory.getLogger(ReverseArrayRunner.class);

	/**
	 * This is the main method of the runner class.
	 * It is used to initialize an array, pass it to the ReverseArray class for the reverse method,
	 * and save the result to a new array.
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };

		int[] reversedArr = ReverseArray.reverse(arr);

		logger.info("Reversed Array Elements:");

		for (int element : reversedArr) {
			logger.info(String.valueOf(element));
		}
	}
}