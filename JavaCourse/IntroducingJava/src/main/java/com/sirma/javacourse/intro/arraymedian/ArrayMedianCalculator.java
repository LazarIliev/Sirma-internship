package com.sirma.javacourse.intro.arraymedian;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.intro.arrayprocessing.ArrayProcessor;

/**
 * This class has a method to find a median of an array.
 */
class ArrayMedianCalculator {
	private static final Logger logger = LoggerFactory.getLogger(ArrayMedianCalculator.class);

	private static final String ERROR_MESSAGE = "The size of array is 0 or array is null.";

	/**
	 * This method finds the median of an array before which the sum of the left part of the elements is
	 * as close as possible to the sum of the right part after the median.
	 *
	 * @param array of integers is passed.
	 * @return integer index of the median plus one.
	 */
	static int findingMedianOfArray(int[] array) {
		if (ArrayProcessor.isArrayEmpty(array)) {

			logger.error(ERROR_MESSAGE);
			return -1;
		}

		int diff = Integer.MAX_VALUE; //the difference between the left and the right side of the array between the median
		int index = 0;
		int leftSum = 0;
		int rightSum = Arrays.stream(array).sum() - array[0];

		for (int i = 0; i < array.length; i++) {

			int tempDiff = Math.abs(leftSum - rightSum);

			if (tempDiff < diff) {
				diff = tempDiff;
				index = i;
			}

			if (i < array.length - 1) {
				leftSum += array[i];
				rightSum -= array[i];
			}
		}

		return index + 1;
	}
}