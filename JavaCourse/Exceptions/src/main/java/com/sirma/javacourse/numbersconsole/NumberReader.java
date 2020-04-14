package com.sirma.javacourse.numbersconsole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to check if number is in the interval 0 and 100 if not throw NumberNotInIntervalException.
 */
class NumberReader {
	private static final Logger logger = LoggerFactory.getLogger(NumberReader.class);
	private static final String ERROR_MESSAGE = "Number should be in interval between 0 and 100!";

	/**
	 * Pass the number parameter to the numberInterval method to check whether number is in interval.
	 *
	 * @param number int value to be checked.
	 */
	NumberReader(int number) {
		numberInterval(number);
	}

	/**
	 * Method for checking if the given number is in interval of 0 and 100.
	 *
	 * @param num
	 */
	private void numberInterval(int num) {
		if (num < 0 || num > 100) {
			throw new NumberNotInIntervalException(ERROR_MESSAGE);
		}
	}
}
