package com.sirma.javacourse.designpatterns.calculator;

/**
 * Interface for executing commands for the calculator. Works with double.
 */
public interface Command {
	/**
	 * Executes and returns command depending on the implementation and uses the given numbers.
	 *
	 * @param a the first number which will be operated
	 * @param b the second number which will be operated
	 * @return the result of the operation
	 */
	String execute(double a, double b);
}
