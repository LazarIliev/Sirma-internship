package com.sirma.javacourse.javagui.messagereversal.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.javagui.utils.SocketUtils;

/**
 * Represents a client. Holds methods for connecting to a server, set a message and start the run method with  the main logic of the client.
 *
 * @see SocketUtils
 */
public class Client {
	private static final Logger logger = LoggerFactory.getLogger(Client.class);
	private PrintWriter writer;
	private BufferedReader reader;
	private ClientView view;
	private Socket socket;
	private String message;

	/**
	 * Creates a new client with given user interface.
	 *
	 * @param view the user interface of the client
	 */
	public Client(ClientView view) {
		this.view = view;
		connectToServer();
	}

	/**
	 * Receive the welcome message from the server.
	 */
	public void receiveConnectedMessage() {
		try {
			view.appendMessageToConsole(reader.readLine());
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}

	/**
	 * Sets the message of the client.
	 * And call the run method of the client.
	 *
	 * @param message the message to be set
	 */
	public void setMessage(String message) {
		this.message = message;
		run();
	}

	/**
	 * Runs the main logic for the client when the message is set.
	 * It sends the message to the server and receive the reversed message from the server.
	 * If the message is "." the client is disconnected from the server and the application is shutdown.
	 */
	public void run() {
		if (message.equals(CommunicationMessages.CLIENT_END_READING_MESSAGE)) {
			sendMessageToServer(message);
			closeStreams();
			view.dispose();
			return;
		}
		sendMessageToServer(message);

		new Thread(() -> {
			try {
				String serverResponse = readMessageFromServer();
				String formattedMessage = String.format("The reverse of [%s] is [%s]", message,
						serverResponse);
				view.appendMessageToConsole(formattedMessage);
				message = null;
			} catch (IOException e) {
				logger.info(e.getMessage(), e);
				view.getConnectButton().setEnabled(true);
				view.getSendButton().setEnabled(false);
				view.appendMessageToConsole("Server is stopped and you are disconnected!");
			}
		}).start();
	}

	/**
	 * Sends a message to the server.
	 *
	 * @param message the message to be sent to the server
	 */
	public void sendMessageToServer(String message) {
		writer.println(message);
	}

	/**
	 * Reads and returns a message from the server.
	 *
	 * @return the read message from the server
	 * @throws IOException thrown when I/O exception occurs
	 */
	public String readMessageFromServer() throws IOException {
		return reader.readLine();
	}

	/**
	 * Extracts the message from client and returns it as {@code MessageMemento}.
	 *
	 * @return memento of the current message
	 */
	public MessageMemento saveMemento() {
		return new MessageMemento(message);
	}

	/**
	 * Restores a given {@code MessageMemento} for this client.
	 *
	 * @param memento the memento from which to be restored
	 */
	public void restoreMemento(MessageMemento memento) {
		this.message = memento.getMessage();
	}

	/**
	 * Connects to a server.
	 */
	private void connectToServer() {
		try {
			socket = SocketUtils.openSocket();
			initializeReaderAndWriter();
		} catch (IOException e) {
			view.showErrorDialog("There is connection problem!");
			logger.info(e.getMessage(), e);
		}
	}

	private void initializeReaderAndWriter() {
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Closes all the streams in the client.
	 */
	private void closeStreams() {
		if (writer != null) {
			writer.close();
		}
		try {
			if (reader != null) {
				reader.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}
}
