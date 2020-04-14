package com.sirma.javacourse.intro.greatestcommondivisor;

/**
 * This class is for finding  greatest common divisor of two integers.
 */
class GCDCalculator {

	GCDCalculator() {
	}

	/**
	 * This method is accepting the two parameter integers and return greatest common divisor of them.
	 *
	 * @param firstNumber  the first number used to calculate the gcd.
	 * @param secondNumber the second number used to calculate the gcd.
	 * @return greatest common divisor of the two parameters.
	 */
	static int calculateGreatestCommonDivisor(int firstNumber, int secondNumber) {
		while (firstNumber != 0) {
			int oldFirstNumber = firstNumber;
			firstNumber = secondNumber % firstNumber;
			secondNumber = oldFirstNumber;
		}

		return secondNumber;
	}
}
