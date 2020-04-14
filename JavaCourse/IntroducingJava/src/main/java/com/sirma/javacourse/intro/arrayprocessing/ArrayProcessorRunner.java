package com.sirma.javacourse.intro.arrayprocessing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is for declaring an array of a sequence of int values.
 * Passing the array to the ArrayProcessor's class methods
 * and print methods' return values to the console for that array.
 */
public class ArrayProcessorRunner {
	private static final Logger logger = LoggerFactory.getLogger(ArrayProcessorRunner.class);

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40 };

		int minElement = ArrayProcessor.getMinElementIndex(arr);

		logger.info("Min element of array: " + minElement);

		logger.info("Elements of the array: ");
		ArrayProcessor.print(arr);

		int sumArray = ArrayProcessor.sum(arr);

		int[] arr2 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		int maxSumOfSubarray = ArrayProcessor.maxSumOfSubarray(arr2);

		logger.info("Max sum of sub-array: " + maxSumOfSubarray);
	}
}
