package com.sirma.javacourse.javagui.calculator;

import java.math.BigDecimal;

/**
 * The model of the calculator.
 */
public class CalculatorModel {
	public static final int INITIAL_VALUE = 0;
	private static final String INFINITY = "Infinity";
	private BigDecimal value;
	private String val;

	/**
	 * Creates new model with initial value zero.
	 */
	public CalculatorModel() {
		this.value = new BigDecimal(INITIAL_VALUE);
		this.val = "";
	}

	/**
	 * Get the value of the model.
	 *
	 * @return value of the model
	 */
	public BigDecimal getValue() {
		return value;
	}

	/**
	 * Sets the value of the model to the given BigDecimal value from string.
	 *
	 * @param newValue the new value to be set
	 */
	public void setValue(String newValue) {
		if (newValue.endsWith(".") || newValue.equals("Error")){
			val = newValue;
			return;
		}
		val = "";
		value = new BigDecimal(newValue);
	}

	/**
	 * Sets the value of the model to the given BigDecimal value.
	 *
	 * @param newValue the new value to be set
	 */
	public void setValue(double newValue) {
		String temp = String.valueOf(newValue).equals(INFINITY) ? "0" : String.valueOf(newValue);
		value = new BigDecimal(temp);
		val = temp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return val.equals("") ? String.valueOf(value) : val;
	}
}
