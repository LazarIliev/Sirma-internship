package com.sirma.javacourse.intro.arrayprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is an array processor that has several methods in it,
 * for each of the methods an array is submitted for which the method does a special job.
 */
 public class ArrayProcessor {
	private static final Logger logger = LoggerFactory.getLogger(ArrayProcessor.class);

	private static final String ERROR_MESSAGE = "The size of array is 0 or array is null.";

	/**
	 * This method is finding the min element into the array.
	 *
	 * @param array of integers is passed.
	 * @return the minimum integer value into the array.
	 */
	 static int getMinElementIndex(int[] array) {

		if (isArrayEmpty(array)) {
			logger.error(ERROR_MESSAGE);
			return -1;
		}

		int minElementIndex = 0;
		int minElement = array[0];

		for (int i = 1; i < array.length; i++) {

			if (array[i] < minElement) {
				minElement = array[i];
				minElementIndex = i;
			}
		}

		return minElementIndex;
	}

	/**
	 * This method is calculating the sum of all elements into the array.
	 *
	 * @param array of integers is passed.
	 * @return the sum of the all elements of the array.
	 */
	static int sum(int[] array) {
		if (isArrayEmpty(array)) {
			logger.error(ERROR_MESSAGE);
			return -1;
		}

		int arraySum = 0;

		for (int element : array) {
			arraySum += element;
		}

		return arraySum;
	}

	/**
	 * This method print on the console each of the array's element .
	 *
	 * @param array of integers is passed.
	 */
	static void print(int[] array) {
		if (isArrayEmpty(array)) {
			logger.error(ERROR_MESSAGE);
			return;
		}

		for (int value : array) {
			logger.info(String.valueOf(value));
		}
	}

	/**
	 * This method is finding the biggest Sub-array's sum.
	 *
	 * @param array of integers is passed.
	 * @return sum of the max sub-array
	 */
	static int maxSumOfSubarray(int[] array) {
		if (isArrayEmpty(array)) {
			logger.error(ERROR_MESSAGE);
			return -1;
		}

		int max = Integer.MIN_VALUE;
		int maxEnding = 0;

		for (int value : array) {
			maxEnding += value;
			if (max < maxEnding) {
				max = maxEnding;
			}
			if (maxEnding < 0) {
				maxEnding = 0;
			}
		}
		return max;
	}

	/**
	 * Checking is the array is empty or null.
	 *
	 * @param array of integers value
	 * @return boolean value if is empty or null.
	 */
	 public static boolean isArrayEmpty(int[] array) {

		return (array == null || array.length == 0);
	}
}
