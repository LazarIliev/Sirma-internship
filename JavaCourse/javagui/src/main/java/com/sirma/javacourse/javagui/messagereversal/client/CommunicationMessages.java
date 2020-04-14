package com.sirma.javacourse.javagui.messagereversal.client;

/**
 * Holds a constants serving for communication between the client and server.
 */
public interface CommunicationMessages {

	/**
	 * Send from the server when the client first connected.
	 */
	String CLIENT_WELCOME_MESSAGE = "Welcome. You can start typing messages:";

	/**
	 * Send from the client. Meaning that the client wants to end session with the server.
	 */
	String CLIENT_END_READING_MESSAGE = ".";
}
