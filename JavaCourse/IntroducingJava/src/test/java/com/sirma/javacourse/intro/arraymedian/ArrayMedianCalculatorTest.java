package com.sirma.javacourse.intro.arraymedian;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayMedianCalculatorTest {

	@Test
	void findingMedianOfArray_fromEmptyArray_shouldReturnMinusOne() {
		int[] arr = {};

		int medianActual = ArrayMedianCalculator.findingMedianOfArray(arr);
		int medianExpected = -1;

		Assertions.assertEquals(medianExpected, medianActual);
	}

	@Test
	void findingMedianOfArray_fromArrayWithEqualValues_shouldReturnCorrectResult() {
		int[] arr = { 3, 3, 3, 3, 3, 3, 3 };

		int medianActual = ArrayMedianCalculator.findingMedianOfArray(arr);
		int medianExpected = 4;

		Assertions.assertEquals(medianExpected, medianActual);
	}

	@Test
	void findingMedianOfArray_fromArrayWithNormalElements_shouldReturnCorrectResult() {
		int[] arr = { 1, 2, 3, 4, 5 };

		int medianActual = ArrayMedianCalculator.findingMedianOfArray(arr);
		int medianExpected = 4;

		Assertions.assertEquals(medianExpected, medianActual);
	}
}