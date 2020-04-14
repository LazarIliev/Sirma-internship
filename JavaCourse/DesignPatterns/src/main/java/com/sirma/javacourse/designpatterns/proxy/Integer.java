package com.sirma.javacourse.designpatterns.proxy;

/**
 * Represents an integer number.
 */
public class Integer implements Number {
	private int number = 0;

	/**
	 * Returns an integer number.
	 *
	 * @return an integer number
	 */
	@Override
	public int getNumber() {
		return number;
	}

	/**
	 * Sets a given integer number.
	 *
	 * @param number an integer number to be set
	 */
	@Override
	public void setNumber(int number) {
		this.number = number;
	}
}
