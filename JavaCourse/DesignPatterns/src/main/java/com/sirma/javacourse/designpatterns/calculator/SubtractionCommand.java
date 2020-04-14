package com.sirma.javacourse.designpatterns.calculator;

/**
 * Represents subtraction in the calculator. Implements {@link Command} interface.
 */
public class SubtractionCommand implements Command {

	/**
	 * Command to subtract one number from another.
	 *
	 * @param a the first number which will be operated
	 * @param b the second number which will be operated
	 * @return number b subtracted from a
	 */
	@Override
	public String execute(double a, double b) {
		return String.valueOf(a - b);
	}
}
