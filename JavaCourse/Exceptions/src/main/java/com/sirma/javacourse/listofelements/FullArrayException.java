package com.sirma.javacourse.listofelements;

/**
 * Custom Exception to indicate that there is no more space to add element in a list.
 */
 class FullArrayException extends RuntimeException {
	/**
	 * Constructor for when the exception is thrown without any particular message.
	 */
	FullArrayException() {
	}

	/**
	 * Constructor for when the exception is thrown with a message.
	 *
	 * @param message the message of the exception
	 */
	FullArrayException(String message) {
		super(message);
	}

	/**
	 * Constructor for when the exception is thrown with a message and the cause is specified.
	 *
	 * @param message the message of the exception
	 * @param cause   the cause of the exception
	 */
	 FullArrayException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for when the exception is thrown and the cause is specified.
	 *
	 * @param cause the cause of the exception
	 */
	 FullArrayException(Throwable cause) {
		super(cause);
	}
}
