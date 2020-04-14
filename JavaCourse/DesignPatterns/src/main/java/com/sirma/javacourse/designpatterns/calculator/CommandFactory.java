package com.sirma.javacourse.designpatterns.calculator;

/**
 * Holds method for creating calculator {@link Command}s.
 */
public final class CommandFactory {
	/**
	 * Protects from instantiation.
	 */
	private CommandFactory() {

	}

	/**
	 * Creates a command object depending on the operation argument.
	 *
	 * @param operation calculator operation on which a command will be created
	 * @return command for the calculator
	 */
	public static Command createCommand(Operations operation) {
		Command command = null;
		switch (operation) {
			case ADD:
				command = new AdditionCommand();
				break;
			case MULTIPLY:
				command = new MultiplicationCommand();
				break;
			case DIVIDE:
				command = new DivisionCommand();
				break;
			case SUBTRACT:
				command = new SubtractionCommand();
				break;
			case POWER:
				command = new PowerCommand();
				break;
			default:
				throw new IllegalArgumentException("No such operation");
		}
		return command;
	}
}
