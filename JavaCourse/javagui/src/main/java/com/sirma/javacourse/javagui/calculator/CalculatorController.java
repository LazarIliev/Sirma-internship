package com.sirma.javacourse.javagui.calculator;

import com.sirma.javacourse.designpatterns.calculator.Command;
import com.sirma.javacourse.designpatterns.calculator.CommandFactory;
import com.sirma.javacourse.designpatterns.calculator.Operations;

/**
 * The controller of the calculator. It knows about the model and the view.
 */
public class CalculatorController {
	private static final String CLEAR_OPERATION = "clear";
	private static final String BACK_OPERATION = "b";
	private static final String EQUALS_OPERATION = "=";
	private static final String DOT = ".";
	private static final String ZERO_AS_STRING = "0";
	private static final String INFINITY = "Infinity";
	private CalculatorModel model;
	private CalculatorView view;
	private StringBuilder num1;
	private StringBuilder num2;
	private StringBuilder result;
	private Operations operation;

	/**
	 * Creates a new calculator controller with given model and view.
	 *
	 * @param model the model of the calculator
	 * @param view the view of the calculator
	 */
	public CalculatorController(CalculatorModel model, CalculatorView view) {
		this.model = model;
		this.view = view;
		num1 = new StringBuilder();
		num2 = new StringBuilder();
		result = new StringBuilder(ZERO_AS_STRING);
	}

	/**
	 * Processes the given command and does the calculation.
	 *
	 * @param command the command from the view to process
	 */
	public void processCommand(String command) {
		if (EQUALS_OPERATION.equals(command)) {
			calculate();
		} else if (CLEAR_OPERATION.equals(command)) {
			resetCalculator();
		} else if (BACK_OPERATION.equals(command)) {
			revertChanges();
		} else if (Operations.ADD.getAction().equals(command)) {
			processOperation(Operations.ADD);
		} else if (Operations.SUBTRACT.getAction().equals(command)) {
			processOperation(Operations.SUBTRACT);
		} else if (Operations.DIVIDE.getAction().equals(command)) {
			processOperation(Operations.DIVIDE);
		} else if (Operations.MULTIPLY.getAction().equals(command)) {
			processOperation(Operations.MULTIPLY);
		} else {
			if (operation == null && !num1.toString().contentEquals(result)) {
				appendStringToStringBuilder(this.num1, command);
			} else if (num2.length() == 0 && num1.toString().contentEquals(result) && operation == null) {
				//this case will be when first calculation is done and we want to continue with the result for the next calculation but we want to modify it.
				trimEndOfResult(result);
				appendStringToStringBuilder(result, command);
				num1.setLength(0);
				num1.append(result.toString());
				result.setLength(0);
			} else {
				appendStringToStringBuilder(this.num2, command);
			}
		}
		updateView(model, view);
	}

	/**
	 * Append a string to a {@link StringBuilder}.
	 * <p>
	 * If {@link StringBuilder} is empty and the string to append is a dot, before the append it adds a leading zero.
	 * If {@link StringBuilder} has a dot and the string to append is again a dot, it break the execution.
	 *
	 * @param num a {@link StringBuilder} instance
	 * @param symbol a string to append
	 */
	private void appendStringToStringBuilder(StringBuilder num, String symbol) {
		if (DOT.equals(symbol) && !num.toString().contains(DOT)) {
			if (num.length() == 0) {
				num.append(ZERO_AS_STRING);
			}
		} else if (DOT.equals(symbol) && num.toString().contains(DOT)) {
			return;
		}
		num.append(symbol);
		model.setValue(String.valueOf(num));
	}

	/**
	 * Updates the view by getting data from the model.
	 *
	 * @param model the calculator model
	 * @param view the calculator view
	 */
	private void updateView(CalculatorModel model, CalculatorView view) {
		if (view != null) {
			String value = model.toString();
			view.setFieldText(value);
		}
	}

	/**
	 * Process the given operation.
	 *
	 * @param operation the calculator operation to process
	 */
	private void processOperation(Operations operation) {
		if (this.operation != null && num2.length() > 0) {
			calculate();
			processOperation(operation);
		}
		this.operation = operation;
		if (num1.length() == 0){
			num1.append(ZERO_AS_STRING);
		}
	}

	/**
	 * Calculates the two numbers in the calculator.
	 */
	private void calculate() {
		if (num2.toString().isEmpty() || num1.toString().isEmpty()){
			return;
		}
		if (operation.getAction().equals(Operations.DIVIDE.getAction()) &&  ZERO_AS_STRING.contentEquals(num2)){
			resetCalculator();
			model.setValue("Error");
			return;
		}
		if (num1.charAt(num1.length() - 1) == '.'){
			num1.deleteCharAt(num1.length() - 1);
		}
		if (num2.charAt(num2.length() - 1) == '.'){
			num2.deleteCharAt(num2.length() - 1);
		}
		double firstNumber = Double.parseDouble(num1.toString());
		double secondNumber = Double.parseDouble(num2.toString());

		double result;
		Command command = CommandFactory.createCommand(operation);
		result = Double.parseDouble(command.execute(firstNumber, secondNumber));
		model.setValue(result);
		num1.setLength(0);
		num2.setLength(0);
		if (String.valueOf(result).equals(INFINITY)) {
			num1.append(ZERO_AS_STRING);
		} else {
			num1.append(result);
		}
		this.result.setLength(0);
		this.result.append(result);
		operation = null;
	}

	/**
	 * Resets the calculator.
	 */
	private void resetCalculator() {
		num1.setLength(0);
		num2.setLength(0);
		operation = null;
		model.setValue(0);
	}

	/**
	 * Reverts the last made change to the current number.
	 */
	private void revertChanges() {
		if (String.valueOf(model.getValue()).equals(INFINITY)) {
			model.setValue(0);
			return;
		}
		if (operation == null) {
			deleteLastCharOfStringBuilder(num1);
		} else if (num2.length() == 0) {
			StringBuilder result = new StringBuilder(String.valueOf(model.getValue()));
			trimEndOfResult(result);
			deleteLastCharOfStringBuilder(result);
		} else {
			deleteLastCharOfStringBuilder(num2);
		}
	}

	private void trimEndOfResult(StringBuilder result) {
		while (result.toString().endsWith(ZERO_AS_STRING)) {
			result.deleteCharAt(result.length() - 1);
		}
		if (result.toString().endsWith(DOT)) {
			result.deleteCharAt(result.length() - 1);
		}
	}

	/**
	 * Delete the last char of a {@link StringBuilder}.
	 *
	 * @param num {@link StringBuilder} from which last char will be removed
	 */
	private void deleteLastCharOfStringBuilder(StringBuilder num) {
		if (num.length() == 0) {
			return;
		}
		num.deleteCharAt(num.length() - 1);
		setModelValue(num);
	}

	private void setModelValue(StringBuilder num){
		if (num.length() == 0) {
			model.setValue(0);
			return;
		}
		model.setValue(num.toString());
	}
}