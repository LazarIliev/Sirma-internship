package com.sirma.javacourse.listofelements;

/**
 * Custom Exception to indicate that a list is empty and there is no elements in it.
 */
 class EmptyArrayException extends RuntimeException {
	/**
	 * Constructor for when the exception is thrown without any particular message.
	 */
	EmptyArrayException() {

	}

	/**
	 * Constructor for when the exception is thrown with a message.
	 *
	 * @param message the message of the exception
	 */
	EmptyArrayException(String message) {
		super(message);
	}

	/**
	 * Constructor for when the exception is thrown with a message and the cause is specified.
	 *
	 * @param message the message of the exception
	 * @param cause   the cause of the exception
	 */
	 EmptyArrayException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for when the exception is thrown and the cause is specified.
	 *
	 * @param cause the cause of the exception
	 */
	 EmptyArrayException(Throwable cause) {
		super(cause);
	}
}
