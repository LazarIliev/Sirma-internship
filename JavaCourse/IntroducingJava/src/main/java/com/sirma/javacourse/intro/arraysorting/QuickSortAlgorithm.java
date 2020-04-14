package com.sirma.javacourse.intro.arraysorting;

/**
 * This class has a method for sorting an array of integers.
 */
class QuickSortAlgorithm {

	/**
	 * It picks one element of an array as the pivot and sorts all of the other elements around it,
	 * for example smaller elements to the left, and larger to the right.
	 * This guarantees that the pivot is in its proper place after the process.
	 * Then the algorithm recursively does the same for the left and right portions of the array.
	 *
	 * @param array of integers for sorting.
	 * @param begin start index of the array.
	 * @param end   index of the array.
	 * @return sorted array.
	 */
	int[] quickSort(int[] array, int begin, int end) {
		if (end <= begin) {
			return array;
		}

		int pivot = partition(array, begin, end);
		quickSort(array, begin, pivot - 1);
		quickSort(array, pivot + 1, end);

		return array;
	}

	private int partition(int[] array, int begin, int end) {
		int pivot = end;

		int counter = begin;
		for (int i = begin; i < end; i++) {
			if (array[i] < array[pivot]) {
				int temp = array[counter];
				array[counter] = array[i];
				array[i] = temp;
				counter++;
			}
		}
		int temp = array[pivot];
		array[pivot] = array[counter];
		array[counter] = temp;

		return counter;
	}
}
