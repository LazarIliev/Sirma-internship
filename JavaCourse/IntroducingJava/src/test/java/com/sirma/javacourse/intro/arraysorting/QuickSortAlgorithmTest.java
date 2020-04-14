package com.sirma.javacourse.intro.arraysorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QuickSortAlgorithmTest {

	private QuickSortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();

	@Test
	void quickSort_withNormalArray_shouldReturnSortedArray() {

		int[] unsortedArr = { 9, 8, 1, 7, 3, 2, 4, 5, 6 };
		int begin = 0;
		int end = unsortedArr.length - 1;

		int[] sortedArr = quickSortAlgorithm.quickSort(unsortedArr, begin, end);

		int[] actualArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Assertions.assertArrayEquals(sortedArr, actualArr);

	}

	@Test
	void quickSort_withEmptyArray_shouldReturnSameArray() {

		int[] unsortedArr = {};
		int begin = 0;
		int end = 0;

		int[] sortedArr = quickSortAlgorithm.quickSort(unsortedArr, begin, end);

		int[] actualArr = {};

		Assertions.assertArrayEquals(sortedArr, actualArr);

	}

	@Test
	void quickSort_withArrayWithAllNegativesElements_shouldReturnSortedArray() {

		int[] unsortedArr = { -1, -34, -90, -2, -7 };
		int begin = 0;
		int end = unsortedArr.length - 1;

		int[] sortedArr = quickSortAlgorithm.quickSort(unsortedArr, begin, end);

		int[] actualArr = { -90, -34, -7, -2, -1 };

		Assertions.assertArrayEquals(sortedArr, actualArr);

	}
}