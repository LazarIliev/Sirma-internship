package com.sirma.javacourse.intro.arraysorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is a runner class.
 */
public class QuickSortAlgorithmRunner {

	private static final Logger logger = LoggerFactory.getLogger(QuickSortAlgorithmRunner.class);

	/**
	 * This is the main method of that package.
	 * Initializing instance of QuickSortAlgorithm.
	 * Declaring an unsorted array.
	 * Passing that unsorted array to the QuickSortAlgorithm's method quickSort.
	 */
	public static void main(String[] args) {

		QuickSortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();

		int[] arr = { 78, 2, 9999, 0, -34, 9, 5 };

		int[] sortedArr = quickSortAlgorithm.quickSort(arr, 0, 6);

		logger.info("Elements of the sorted array.");

		for (int element : sortedArr) {
			logger.info(String.valueOf(element));
		}
	}
}
