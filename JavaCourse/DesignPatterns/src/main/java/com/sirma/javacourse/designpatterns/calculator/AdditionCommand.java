package com.sirma.javacourse.designpatterns.calculator;

/**
 * Represents addition in the calculator. Implements {@link Command} interface.
 */
public class AdditionCommand implements Command {

	/**
	 * Command for summing two numbers.
	 *
	 * @param a the first number which will be operated
	 * @param b the second number which will be operated
	 * @return sum of a and b
	 */
	@Override
	public String execute(double a, double b) {
		return String.valueOf(a + b);
	}
}
