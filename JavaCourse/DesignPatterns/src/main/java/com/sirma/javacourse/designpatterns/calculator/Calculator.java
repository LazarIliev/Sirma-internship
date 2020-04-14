package com.sirma.javacourse.designpatterns.calculator;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Executes commands given from stream to work with the Calculator.
 */
class Calculator {
	private static final Logger logger = LoggerFactory.getLogger(Calculator.class);
	private static final String LEFT_BRACKET = "(";
	private static final String RIGHT_BRACKET = ")";
	private static final char DOT = '.';

	/**
	 * Evaluating a complex expression for the most common mathematics operation:Addition, Subtraction, Division, Multiplication and Power.
	 * <p>
	 * It manages operation order and if there are brackets as well.
	 *
	 * @param expression for evaluating
	 * @return result of the expression
	 */
	String calc(String expression) {
		int pos = 0;
		logger.info("Solving expression: " + expression);
		//Extracting expression from braces, doing recursive call
		//replace braced expression on result of it solving
		if (-1 != (pos = expression.indexOf(LEFT_BRACKET))) {
			String subexp = extractExpressionFromBraces(expression, pos);
			expression = expression.replace(LEFT_BRACKET + subexp + RIGHT_BRACKET, calc(subexp));
			return calc(expression);
		} else if (expression.indexOf(Operations.POWER.getAction()) > 0) {
			return extractCommandOperation(expression, Operations.POWER.getAction(), Operations.POWER.getAction());
		} else if (expression.indexOf(Operations.MULTIPLY.getAction()) > 0
				| expression.indexOf(Operations.DIVIDE.getAction()) > 0) {
			return extractCommandOperation(expression, Operations.MULTIPLY.getAction(), Operations.DIVIDE.getAction());
		} else if (expression.indexOf(Operations.ADD.getAction()) > 0
				| expression.indexOf(Operations.SUBTRACT.getAction()) > 0) {
			return extractCommandOperation(expression, Operations.ADD.getAction(), Operations.SUBTRACT.getAction());
		} else {
			return expression;
		}
	}

	private String extractCommandOperation(String expression, String firstOperatorIndex, String secondOperatorIndex) {
		int firstOperator = expression.indexOf(firstOperatorIndex);
		int secondOperator = expression.indexOf(secondOperatorIndex);

		int pos = Math.min(firstOperator, secondOperator);
		if (firstOperator < 0) {
			pos = secondOperator;
		} else if (secondOperator < 0) {
			pos = firstOperator;
		}
		String divider = String.valueOf(expression.charAt(pos));
		Operations operation = Arrays.stream(Operations.values())
				.filter(operations -> operations.getAction().equals(divider))
				.findFirst()
				.orElse(null);

		String leftNum = extractNumber(expression, pos, false);
		String rightNum = extractNumber(expression, pos, true);

		assert operation != null;
		expression = expression.replace(leftNum + divider + rightNum,
				calcShortExpr(leftNum, rightNum, operation));

		return calc(expression);
	}

	private String extractExpressionFromBraces(String expression, int pos) {
		int braceDepth = 1;
		String subexp = "";

		for (int i = pos + 1; i < expression.length(); i++) {
			switch (String.valueOf(expression.charAt(i))) {
				case LEFT_BRACKET:
					braceDepth++;
					subexp += LEFT_BRACKET;
					break;
				case RIGHT_BRACKET:
					braceDepth--;
					if (braceDepth != 0) {
						subexp += RIGHT_BRACKET;
					}
					break;
				default:
					if (braceDepth > 0) {
						subexp += expression.charAt(i);
					}
			}
			if (braceDepth == 0 && !subexp.equals("")) {
				return subexp;
			}
		}
		return subexp;
	}

	/**
	 * Extract a number in a string expression from a starting position with specified direction
	 * with a boolean false for left direction and true for right direction.
	 *
	 * @param expression of the whole
	 * @param pos of the start of the number
	 * @param isRightDirection boolean for the direction false for left and true for right
	 * @return number as string
	 */
	private String extractNumber(String expression, int pos, boolean isRightDirection) {
		String resultNumber = "";
		int direction = -1;
		if (isRightDirection) {
			direction = 1;
		}

		int currPos = pos + direction;//shift pos on next symbol from divider -1/1
		//For negative numbers
		if (expression.charAt(currPos) == Operations.SUBTRACT.getAction().charAt(0)) {
			resultNumber += Operations.SUBTRACT.getAction();
			currPos += direction;
		}

		for (; currPos >= 0 &&
				currPos < expression.length() &&
				Character.isDigit(expression.charAt(currPos)) | expression.charAt(currPos) == DOT;
			 currPos += direction) {
			resultNumber += expression.charAt(currPos);
		}

		if (!isRightDirection) {
			resultNumber = new
					StringBuilder(resultNumber).reverse().toString();
		}
		return resultNumber;
	}

	private String calcShortExpr(String leftNum, String rightNum, Operations divider) {
		switch (divider) {
			case POWER:
				return CommandFactory.createCommand(Operations.POWER)
						.execute(Double.parseDouble(leftNum), Double.parseDouble(rightNum));
			case MULTIPLY:
				return CommandFactory.createCommand(Operations.MULTIPLY)
						.execute(Double.parseDouble(leftNum), Double.parseDouble(rightNum));
			case DIVIDE:
				return CommandFactory.createCommand(Operations.DIVIDE)
						.execute(Double.parseDouble(leftNum), Double.parseDouble(rightNum));
			case ADD:
				return CommandFactory.createCommand(Operations.ADD)
						.execute(Double.parseDouble(leftNum), Double.parseDouble(rightNum));
			case SUBTRACT:
				return CommandFactory.createCommand(Operations.SUBTRACT)
						.execute(Double.parseDouble(leftNum), Double.parseDouble(rightNum));
			default:
				return "0";
		}
	}
}
