package com.sirma.javacourse.intro.greatestcommondivisor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GCDCalculatorTest {

	@Test
	public void calculateGreatestCommonDivisor_withNormalIntegersValue_shouldWorkCorrect() {
		int firstNumber = 15;
		int secondNumber = 24;

		int actual = GCDCalculator.calculateGreatestCommonDivisor(firstNumber, secondNumber);
		int expected = 3;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void calculateGreatestCommonDivisor_withEqualNumbers_shouldReturnThatNumber() {
		int firstNumber = 13;
		int secondNumber = 13;

		int actual = GCDCalculator.calculateGreatestCommonDivisor(firstNumber, secondNumber);
		int expected = 13;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void calculateGreatestCommonDivisor_withTwoNumbersInStraightAndInvertedOrder_shouldReturnOneResult() {
		int firstNumber = 16;
		int secondNumber = 13;

		int actual = GCDCalculator.calculateGreatestCommonDivisor(firstNumber, secondNumber);
		int expected = GCDCalculator.calculateGreatestCommonDivisor(secondNumber, firstNumber);

		Assertions.assertEquals(expected, actual);
	}
}