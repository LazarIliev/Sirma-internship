package com.sirma.javacourse.intro.summinglargenumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumLargeNumbersTest {

	@Test
	void calculateSumOfTwoNumbersAsStrings_withNormalInput_shouldReturnCorrectResult() {
		String numberOneAsString = "1450";
		String numberTwoAsString = "150";

		String actualSum = SumLargeNumbers.sum(numberOneAsString, numberTwoAsString);
		String expectedSum = "1600";

		Assertions.assertEquals(expectedSum, actualSum);
	}

	@Test
	void calculateSumOfTwoNumbersAsStrings_withOneEmptyValue_shouldReturnCorrectResult() {
		String numberOneAsString = "125";
		String numberTwoAsString = "";

		String actualSum = SumLargeNumbers.sum(numberOneAsString, numberTwoAsString);
		String expectedSum = "125";

		Assertions.assertEquals(expectedSum, actualSum);
	}

	@Test
	void calculateSumOfTwoNumbersAsStrings_withOneZeroValue_shouldReturnCorrectResult() {
		String numberOneAsString = "0";
		String numberTwoAsString = "125";

		String actualSum = SumLargeNumbers.sum(numberOneAsString, numberTwoAsString);
		String expectedSum = "125";

		Assertions.assertEquals(expectedSum, actualSum);
	}
}