package com.sirma.javacourse.javagui.messagereversal.client;

/**
 * Holds a message. This class is part of the Memento design pattern.
 */
public class MessageMemento {
	private String message;

	/**
	 * Create a new memento with given message.
	 *
	 * @param message message to be set on the memento
	 */
	public MessageMemento(String message) {
		this.message = message;
	}

	/**
	 * Sets the message in the memento.
	 *
	 * @param message message to be set on the memento
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Returns the message in the memento.
	 *
	 * @return the message in the memento
	 */
	public String getMessage() {
		return message;
	}

}
