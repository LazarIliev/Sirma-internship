package com.sirma.javacourse.designpatterns.calculator;

/**
 * Represents division in the calculator. Implements {@link Command} interface.
 */
public class DivisionCommand implements Command {

	/**
	 * Command for dividing two numbers.
	 *
	 * @param a the first number which will be operated
	 * @param b the second number which will be operated
	 * @return result of the first number divided into the second number.
	 */
	@Override
	public String execute(double a, double b) {
		return String.valueOf(a / b);
	}
}
