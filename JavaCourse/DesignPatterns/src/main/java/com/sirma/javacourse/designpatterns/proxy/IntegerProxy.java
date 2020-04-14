package com.sirma.javacourse.designpatterns.proxy;

/**
 * Proxy for {@link Integer}.
 */
public class IntegerProxy implements Number {
	private Integer integer;

	IntegerProxy() {
		this.integer = new Integer();
	}

	/**
	 *  Sets a given integer number.
	 *
	 * @param number an integer number to be set
	 */
	@Override
	public void setNumber(int number) {
		if (number > java.lang.Integer.MIN_VALUE && number < java.lang.Integer.MAX_VALUE) {
			integer.setNumber(number);
		} else {
			throw new IllegalArgumentException(
					String.format("The given integer cannot fit in this structure. The range is: [%d, %d]",
							java.lang.Integer.MAX_VALUE, java.lang.Integer.MAX_VALUE));
		}
	}

	/**
	 * Returns an integer number.
	 *
	 * @return an integer number
	 */
	@Override
	public int getNumber() {
		return integer.getNumber();
	}

	/**
	 * return the number value of the {@link Integer} as string.
	 */
	@Override
	public String toString() {
		return String.valueOf((getNumber()));
	}
}
