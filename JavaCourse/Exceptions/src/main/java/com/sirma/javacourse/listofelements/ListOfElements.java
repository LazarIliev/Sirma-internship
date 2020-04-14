package com.sirma.javacourse.listofelements;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holds list of elements of type Object with fixed size.
 */
class ListOfElements {
	private static final Logger logger = LoggerFactory.getLogger(ListOfElements.class);

	private static final String FULL_ARRAY_MESSAGE = "The array is full.";
	private static final String EMPTY_ARRAY_MESSAGE = "The array is empty";

	private final Object[] array;
	private int iterator = 0;

	/**
	 * Initialize an array of Objects with specific length.
	 *
	 * @param length int value for the length of the array.
	 */
	ListOfElements(int length) {
		array = new Object[length];
	}

	/**
	 * Adding an object to the array. If the array's length exceeds the specified length, a
	 * FullArrayException is thrown.
	 *
	 * @param obj the object to be added to the array.
	 */
	void add(Object obj) {
		if (iterator == array.length) {
			throw new FullArrayException(FULL_ARRAY_MESSAGE);
		}
		array[iterator++] = obj;
	}

	/**
	 * Removing an object from the array. If there is nothing to remove and an exception is thrown.
	 */
	void remove() {
		if (iterator == 0) {
			throw new EmptyArrayException(EMPTY_ARRAY_MESSAGE);
		}
		array[--iterator] = null;
	}

	/**
	 * A method, printing out all elements of the array in the console.
	 */
	void printAllElements() {
		logger.info(Arrays.toString(array));
	}
}
