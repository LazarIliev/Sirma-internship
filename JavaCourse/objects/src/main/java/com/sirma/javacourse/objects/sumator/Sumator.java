package com.sirma.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Sumator {
	private static final Logger logger = LoggerFactory.getLogger(Sumator.class);

	private static final String ERROR_MESSAGE_NUMBER_FORMAT = "The input must contain only numbers";
	/**
	 * Sums two numbers of type Integer.
	 *
	 * @param a first number to sum
	 * @param b second number to sum
	 * @return a + b
	 */
	int sum(int a, int b) {
		return a + b;
	}

	/**
	 * Sums two numbers of type Float.
	 *
	 * @param a first number to sum
	 * @param b second number to sum
	 * @return a + b
	 */
	float sum(float a, float b) {
		return a + b;
	}

	/**
	 * Sums two numbers of type Double.
	 *
	 * @param a first number to sum
	 * @param b second number to sum
	 * @return a + b
	 */
	double sum(double a, double b) {
		return a + b;
	}

	/**
	 * Sums two numbers of type BigInteger.
	 *
	 * @param a first number to sum
	 * @param b second number to sum
	 * @return a + b
	 */
	BigInteger sum(BigInteger a, BigInteger b) {
		return a.add(b);
	}

	/**
	 * Sums two numbers of type BigDecimal.
	 *
	 * @param a first number to sum
	 * @param b second number to sum
	 * @return a + b
	 */
	BigDecimal sum(BigDecimal a, BigDecimal b) {
		return a.add(b);
	}

	/**
	 * Sums two numbers given as String.
	 *
	 * @param a first number as string to sum
	 * @param b second numbers as string to sum
	 * @return a + b
	 */
	String sum(String a, String b) {
		int num1 = 0;
		int num2 = 0;

		try {
			num1 = Integer.parseInt(a);
			num2 = Integer.parseInt(b);
		}catch (NumberFormatException e) {
			logger.info(ERROR_MESSAGE_NUMBER_FORMAT, e);
			return null;
		}
		return String.valueOf(sum(num1, num2));
	}
}
