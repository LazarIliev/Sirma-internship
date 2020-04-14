package com.sirma.javacourse.intro.greatestcommondivisor;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The example class is a runner class.
 */
public class GCDCalculatorRunner {

	private static final Logger logger = LoggerFactory.getLogger(GCDCalculatorRunner.class);

	/**
	 * This is the main method and entry point of the file.
	 * Provide a way to get user input from the console
	 * and pass it to GCDCalculator class's method for getting  greatest common divisor of two integers.
	 */
	public static void main(String[] args) {
		Scanner myInput = new Scanner(System.in);
		int firstNumber;
		int secondNumber;

		firstNumber = myInput.nextInt();
		secondNumber = myInput.nextInt();

		if (firstNumber <= 0 || secondNumber <= 0) {
			logger.info("The value of the both numbers should be bigger than 0!");

			return;
		}

		int greatestCommonDivisor = GCDCalculator.calculateGreatestCommonDivisor(firstNumber, secondNumber);
		logger.info(String.valueOf(greatestCommonDivisor));

		int leastCommonMultiple = (firstNumber * secondNumber) / greatestCommonDivisor;
		logger.info(String.valueOf(leastCommonMultiple));
	}
}
