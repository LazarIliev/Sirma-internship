package com.sirma.javacourse.javagui.messagereversal.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.javagui.messagereversal.client.CommunicationMessages;

/**
 * Reverses a messages from the client.
 */
public class ClientHandler implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(ClientHandler.class);
	private Socket clientSocket;
	private PrintWriter writer;
	private BufferedReader reader;
	private ServerView view;

	/**
	 * Creates a new handler for a client with given socket and user interface of the server.
	 *
	 * @param socket the socket of the client
	 * @param view the user interface of the server
	 */
	public ClientHandler(Socket socket, ServerView view) {
		this.clientSocket = socket;
		this.view = view;
		createStreams();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			writer.println(CommunicationMessages.CLIENT_WELCOME_MESSAGE);
			while (!Thread.currentThread().isInterrupted()) {
				String clientMessage = readClientMessage();
				if (CommunicationMessages.CLIENT_END_READING_MESSAGE.equals(clientMessage)) {
					view.appendMessageToConsole(">> A client is disconnected");
					break;
				}
				view.appendMessageToConsole("Client sends a message: " + clientMessage);
				String reversedMessage = reverseMessage(clientMessage);
				view.appendMessageToConsole(
						"Server will send back the reversed message from the client: " + reversedMessage);
				writeMessage(reversedMessage);
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}

	/**
	 * Reads a message from the client.
	 *
	 * @return a message from the client
	 * @throws IOException thrown when I/O exception occurs
	 */
	public String readClientMessage() throws IOException {
		return reader.readLine();
	}

	/**
	 * Writes the given message as reversed to the client.
	 *
	 * @param message the message that will be reversed and sent to the client
	 */
	public void writeMessage(String message) {
		writer.println(message);
	}

	/**
	 * Sets that the server has stopped.
	 */
	public synchronized void setServerStopped() {
		closeStreams();
	}

	/**
	 * Reverses and returns a given message.
	 *
	 * @param message the message to be reversed
	 * @return the reversed message
	 */
	private String reverseMessage(String message) {
		StringBuilder reversedMessage = new StringBuilder(message);
		return reversedMessage.reverse().toString();
	}

	/**
	 * Creates the streams for the client.
	 */
	private void createStreams() {
		try {
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}

	/**
	 * Closes the streams for the client.
	 */
	private void closeStreams() {
		if (writer != null) {
			writer.close();
		}
		try {
			if (reader != null) {
				reader.close();
			}
			if (clientSocket != null) {
				clientSocket.close();
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}
}
