package com.sirma.javacourse.collections.exceptionmanager;

/**
 * Holds defined enumerations with predefined messages.
 */
public enum ExceptionMessages {
	DebitCart("Invalid debit cart ID"), PersonalID("Invalid personal ID"), PostalCode("Invalid postal code");

	private String message;

	/**
	 * Constructs enum with a specified message.
	 *
	 * @param message message of the enumeration
	 */
	ExceptionMessages(String message) {
		this.message = message;
	}

	/**
	 * Returns the message of the enumeration type.
	 *
	 * @return message of the enumeration type
	 */
	public String getMessage() {
		return message;
	}
}
