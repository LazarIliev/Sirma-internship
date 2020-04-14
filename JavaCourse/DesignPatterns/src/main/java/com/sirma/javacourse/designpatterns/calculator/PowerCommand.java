package com.sirma.javacourse.designpatterns.calculator;

/**
 * Represents multiplication in the calculator. Implements {@link Command} interface.
 */
public class PowerCommand implements Command {

	/**
	 * Command to power one number by another.
	 * The power b must be an integer number.
	 *
	 * @param a the first number which will be operated
	 * @param b the second number which will be operated
	 * @return number a powered by number b
	 */
	@Override
	public String execute(double a, double b) {
		return String.valueOf(Math.pow(a, b));
	}
}
