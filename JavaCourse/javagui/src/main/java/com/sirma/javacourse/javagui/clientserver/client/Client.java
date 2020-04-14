package com.sirma.javacourse.javagui.clientserver.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.sirma.javacourse.javagui.utils.SocketUtils;

/**
 * Communicates with server socket and reads from its stream.
 */
public class Client {
	private String receivedMessage = "";
	private ClientView clientView;

	public Client(ClientView clientView) {
		this.clientView = clientView;
	}

	/**
	 * Returns the read message from the server socket.
	 *
	 * @return the read message from the server socket.
	 */
	public synchronized String getReceivedMessage() {
		return receivedMessage;
	}

	/**
	 * Connects to the server socket and reads from its stream.
	 *
	 * @throws IOException thrown when the server socket is closed.
	 */
	public void connectToServer() throws IOException {
		try (Socket socket = SocketUtils.openSocket();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));) {
			receivedMessage = in.readLine();

			clientView.appendMessage(receivedMessage + System.lineSeparator() + "Closed the connection with the server."
					+ System.lineSeparator());
		}
	}
}