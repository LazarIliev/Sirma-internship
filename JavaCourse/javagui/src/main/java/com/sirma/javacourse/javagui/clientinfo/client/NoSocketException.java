package com.sirma.javacourse.javagui.clientinfo.client;

/**
 * Thrown when the Server in a Client/Server application stops.
 */
public class NoSocketException extends Exception {
	private static final long serialVersionUID = 5354443218828873751L;

	/**
	 * Create a new {@link NoSocketException} with given message.
	 *
	 * @param message message for the exception
	 */
	public NoSocketException(String message) {
		super(message);
	}

	/**
	 * Create a new {@link NoSocketException} with given message and caused exception.
	 *
	 * @param message message for the exception
	 * @param cause the caused exception
	 */
	public NoSocketException(String message, Throwable cause) {
		super(message, cause);
	}

}
