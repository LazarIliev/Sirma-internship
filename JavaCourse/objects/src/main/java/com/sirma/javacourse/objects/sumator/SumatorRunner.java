package com.sirma.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The runner class for the Sumator class.
 */
public class SumatorRunner {

	private static final Logger logger = LoggerFactory.getLogger(SumatorRunner.class);

	/**
	 * The main method of the runner class.
	 *
	 * @param args
	 */
	public static void main(String args[]) {
		Sumator sumator = new Sumator();
		logger.info("The sum of the int a and b is " + sumator.sum(10, 5));
		logger.info("The sum of the floating point a and b is " + sumator.sum(2.0, 3.0));
		logger.info("The sum of a and b represented " + "by strings is " + sumator.sum("6", "4"));
		BigInteger firstBigInt = new BigInteger("288444");
		BigInteger secondBigInt = new BigInteger("334353");
		logger.info("The sum of the BigIntegers a and b is " + sumator.sum(firstBigInt, secondBigInt));
		BigDecimal firstBigDecimal = new BigDecimal("546464747472");
		BigDecimal secondBigDecimal = new BigDecimal("53536536536");
		logger.info("The sum of the BigDecimals a and b is " + sumator.sum(firstBigDecimal, secondBigDecimal));
	}
}
