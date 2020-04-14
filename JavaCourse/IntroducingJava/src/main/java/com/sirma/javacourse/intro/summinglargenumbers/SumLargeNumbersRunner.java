package com.sirma.javacourse.intro.summinglargenumbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumLargeNumbersRunner {
	private static final Logger logger = LoggerFactory.getLogger(SumLargeNumbersRunner.class);

	public static void main(String[] args) {
		String numberOneAsString = "109";
		String numberTwoAsString = "11";

		String sum = SumLargeNumbers.sum(numberOneAsString, numberTwoAsString);

		logger.info(sum);
	}
}
