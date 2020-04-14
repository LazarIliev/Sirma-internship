package com.sirma.javacourse.intro.arraymedian;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a runner class for declaring an array of a sequence of int values.
 * Passing the array to the ArrayMedianCalculator's method findingMedianOfArray.
 * Print the array's index of his median.
 */
public class ArrayMedianCalculatorRunner {
	private static final Logger logger = LoggerFactory.getLogger(ArrayMedianCalculatorRunner.class);

	public static void main(String[] args) {
		int[] arr = {};

		int indexMedian = ArrayMedianCalculator.findingMedianOfArray(arr);

		logger.info("Index of the array's medina is: " + indexMedian);
	}
}
