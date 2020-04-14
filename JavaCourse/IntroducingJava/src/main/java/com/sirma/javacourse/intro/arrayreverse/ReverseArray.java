package com.sirma.javacourse.intro.arrayreverse;

/**
 * This class has a method to reverse an array and return it.
 */
class ReverseArray {

	ReverseArray() {
	}

	/**
	 * This method is looping through the array until reaches the middle of that array. On the first loop it is swapping
	 * the first element with the last one, on the second loop it is swapping the second element with the one before
	 * the last one and so on until the middle of the array is reached.
	 *
	 * @param arr of integers is passed.
	 * @return reversed arr.
	 */
	static int[] reverse(int[] arr) {
		int lengthArr = arr.length;

		for (int i = 0; i < lengthArr / 2; i++) {
			int temp = arr[i];

			arr[i] = arr[lengthArr - i - 1];
			arr[lengthArr - i - 1] = temp;
		}

		return arr;
	}
}
