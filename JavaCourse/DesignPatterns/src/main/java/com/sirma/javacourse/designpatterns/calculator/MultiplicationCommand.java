package com.sirma.javacourse.designpatterns.calculator;

/**
 * Represents multiplication in the calculator. Implements {@link Command} interface.
 */
public class MultiplicationCommand implements Command {

	/**
	 * Command to multiply one number by another number.
	 *
	 * @param a the first number which will be operated
	 * @param b the second number which will be operated
	 * @return multiplication of the two numbers
	 */
	@Override
	public String execute(double a, double b) {
		return String.valueOf(a * b);
	}
}