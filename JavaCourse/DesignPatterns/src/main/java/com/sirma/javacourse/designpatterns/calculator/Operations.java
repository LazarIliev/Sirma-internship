package com.sirma.javacourse.designpatterns.calculator;


/**
 * Holds constants for calculator operations.
 */
public enum Operations {
	SUBTRACT("-"),
	ADD("+"),
	DIVIDE("/"),
	MULTIPLY("*"),
	POWER("^");

	public String getAction() {
		return action;
	}

	Operations(String action) {
		this.action = action;
	}

	private final String action;
}
