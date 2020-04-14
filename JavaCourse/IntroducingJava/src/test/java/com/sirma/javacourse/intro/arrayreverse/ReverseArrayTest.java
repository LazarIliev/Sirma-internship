package com.sirma.javacourse.intro.arrayreverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseArrayTest {

	@Test
	void reverse_arrayWithNormalElements_shouldReturnReversedArray() {

		int[] arr = { 1, 2, 3, 4, 5, 6 };

		int[] actualReversedArr = ReverseArray.reverse(arr);
		int[] expectedReversedArr = { 6, 5, 4, 3, 2, 1 };

		Assertions.assertArrayEquals(expectedReversedArr, actualReversedArr);
	}

	@Test
	void reverse_emptyArray_shouldReturnSameEmptyArray() {

		int[] arr = {};

		int[] actualReversedArr = ReverseArray.reverse(arr);
		int[] expectedReversedArr = {};

		Assertions.assertArrayEquals(expectedReversedArr, actualReversedArr);
	}
}