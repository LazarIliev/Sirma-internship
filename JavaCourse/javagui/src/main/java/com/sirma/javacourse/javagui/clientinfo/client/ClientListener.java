package com.sirma.javacourse.javagui.clientinfo.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import com.sirma.javacourse.javagui.clientinfo.server.Server;
import com.sirma.javacourse.javagui.clientinfo.View;
import com.sirma.javacourse.javagui.utils.SocketUtils;

/**
 * Class for updating the client's view when new client is connected.
 */
public class ClientListener implements Runnable {
	private View clientView;
	private Socket socket;
	private BufferedReader reader;


	/**
	 * Initialize {@link ClientListener} instance with a view for the client.
	 *
	 * @param clientView of the client
	 */
	public ClientListener(View clientView) {
		this.clientView = clientView;
		initializeSocketAndReader();
	}

	/**
	 * Runs a thread for the client and connect it to the server.
	 */
	@Override
	public void run() {
		try  {
			clientView.appendMessageToConsole("Connected to the server...");
			readLoop();
		} catch (IOException | NoSocketException e) {
			clientView.disposeView();
			closeSocket();
		}
	}

	/**
	 * Reads from the sockets stream in a loop until the server sends the string for termination of
	 * the server.
	 *
	 * @throws IOException thrown when I/O exception occurs
	 */
	private void readLoop() throws IOException, NoSocketException {
		String serverResponse = "";
		while (!Thread.currentThread().isInterrupted() && !Server.CLOSING_SERVER_MESSAGE.equalsIgnoreCase(
				serverResponse ) && serverResponse != null  ) {
			serverResponse = reader.readLine();//
			clientView.appendMessageToConsole(serverResponse);
		}
		throw new NoSocketException("The server has stopped.");
	}

	private void initializeSocketAndReader(){
		try {
			socket = SocketUtils.openSocket();
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		} catch (IOException e) {
			clientView.showErrorDialog(e.getMessage());
		}
	}

	private void closeSocket() {
		try {
			socket.close();
		} catch (IOException e) {
			clientView.showErrorDialog(e.getMessage());
		}
	}
}
