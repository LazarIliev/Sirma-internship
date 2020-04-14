package com.sirma.javacourse.threads.synchronizedstack;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holds list of elements of type Object with fixed size.
 */
class ListOfElements {
	private static final Logger logger = LoggerFactory.getLogger(ListOfElements.class);

	private final Object[] array;
	private int iterator;

	/**
	 * Initialize an array of Objects with specific length.
	 *
	 * @param length int value for the length of the array.
	 */
	ListOfElements(int length) {
		array = new Object[length];
	}

	/**
	 * Adds given element to the list by starting a new {@link AddThread}.
	 *
	 * @param obj the element to be added from a thread
	 */
	void add(Object obj) {
		new AddThread(this, obj);
	}

	/**
	 * Adding an object to the array. If the array's length is equal to the specified length it waits until the remove
	 * method is not used.
	 *
	 * @param obj the object to be added to the array.
	 */
	synchronized void addItem(Object obj) {
		if (iterator == array.length) {
			logger.info("Waiting for the remove method.");
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		array[iterator++] = obj;
		notifyAll();
	}

	/**
	 * Removes the last element of the list by starting a new {@link RemoveThread}.
	 */
	void remove() {
		new RemoveThread(this);
	}

	/**
	 * Removing an object from the array. If there is nothing to remove wait until the add method is not used.
	 */
	synchronized void removeItem() {
		if (iterator == 0) {
			logger.info("Waiting for the add method.");
			try {
				wait();
			} catch (InterruptedException e) {
				return;
			}
		}
		array[--iterator] = null;
		notifyAll();
	}

	/**
	 * A method, getting all elements of the array.
	 *
	 * @return string with all elements
	 */
	String getAllElements()  {
		return Arrays.toString(array);
	}
}
