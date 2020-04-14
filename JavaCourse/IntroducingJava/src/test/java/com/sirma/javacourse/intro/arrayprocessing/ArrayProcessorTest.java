package com.sirma.javacourse.intro.arrayprocessing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayProcessorTest {

	@Test
	void getMinElementIndex_fromEmptyArray_shouldReturnMinusOne() {
		int[] arr = {};

		int actual = ArrayProcessor.getMinElementIndex(arr);
		int expected = -1;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void getMinElementIndex_fromArrayWithEqualMinimumValues_shouldReturnFirstIndexOfThatValue() {
		int[] arr = { 99, -30, 45, -30 };

		int actual = ArrayProcessor.getMinElementIndex(arr);
		int expected = 1;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void getMinElementIndex_fromArrayWithNormalValues_shouldReturnCorrectResult() {
		int[] arr = { -1, 200, 0, -56, 34, -99 };

		int actual = ArrayProcessor.getMinElementIndex(arr);
		int expected = 5;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void sum_emptyArray_shouldReturnMinusOne() {
		int[] arr = {};

		int actual = ArrayProcessor.sum(arr);
		int expected = -1;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void sum_arrayWithOneElement_shouldReturnThatElement() {
		int[] arr = { 20 };

		int actual = ArrayProcessor.sum(arr);
		int expected = 20;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void sum_arrayWithAllNegativesElement_shouldReturnCorrectResult() {
		int[] arr = { -20, -50, -40 };

		int actual = ArrayProcessor.sum(arr);
		int expected = -110;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void sum_arrayWithDifferentElements_shouldReturnCorrectResult() {
		int[] arr = { -20, 50, -40 };

		int actual = ArrayProcessor.sum(arr);
		int expected = -10;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void maxSumOfSubarray_fromEmptyArray_shouldReturnMinusOne() {
		int[] arr = {};

		int actual = ArrayProcessor.maxSumOfSubarray(arr);
		int expected = -1;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void maxSumOfSubarray_fromArrayWithOneElement_shouldReturnThatElement() {
		int[] arr = { 20 };

		int actual = ArrayProcessor.maxSumOfSubarray(arr);
		int expected = 20;

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void maxSumOfSubarray_fromArrayNormalElements_shouldReturnThatElement() {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

		int actual = ArrayProcessor.maxSumOfSubarray(arr);
		int expected = 7;

		Assertions.assertEquals(expected, actual);
	}
}