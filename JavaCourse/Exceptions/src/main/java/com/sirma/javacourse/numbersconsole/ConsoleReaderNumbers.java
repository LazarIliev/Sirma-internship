package com.sirma.javacourse.numbersconsole;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for reading number from the console.
 */
 public class ConsoleReaderNumbers {
	private static final Logger logger = LoggerFactory.getLogger(ConsoleReaderNumbers.class);
	private static final String ERROR_MESSAGE = "Number should be in interval between 0 and 100!";

	public static void main(String[] args) {
		int num;
		logger.info("Enter the integer: ");
		Scanner s = new Scanner(System.in);

		num = s.nextInt();
		NumberReader numberReader = new NumberReader(num);
	}
}
