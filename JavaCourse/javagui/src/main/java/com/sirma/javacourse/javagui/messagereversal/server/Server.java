package com.sirma.javacourse.javagui.messagereversal.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.javagui.utils.SocketUtils;

/**
 * Represents a server. Holds methods for starting and stopping a server. When a client is accepted
 * it transmits him to a {@code ClientHandler} thread.
 */
public class Server implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Server.class);
	private ServerSocket serverSocket;
	private ServerView view;
	private Thread threadServer;
	private final List<ClientHandler> clientHandlersList;

	/**
	 * Creates a new server with given user interface.
	 *
	 * @param view the user interface of the server
	 */
	public Server(ServerView view) {
		this.clientHandlersList = new ArrayList<>();
		this.view = view;
		try {
			serverSocket = SocketUtils.openServerSocket();
		} catch (IOException e) {
			view.showErrorDialog("Cannot start a server. Please try again.");
			logger.info(e.getMessage(), e);
		}
	}

	/**
	 * Starts the server.
	 */
	public void startServer() {
		view.appendMessageToConsole(">> Server started at port: " + serverSocket.getLocalPort());
		threadServer = new Thread(this);
		threadServer.start();
	}

	/**
	 * Reads client's message reverse it and send it back to the client until client sends a message with a dot or if the thread is interrupted.
	 */
	@Override
	public void run() {
		while (!threadServer.isInterrupted()) {
			Socket clientSocket = acceptClient();
			ClientHandler clientHandler = new ClientHandler(clientSocket, view);
			clientHandlersList.add(clientHandler);
			new Thread(clientHandler).start();
		}
	}

	/**
	 * Stops the server.
	 */
	public void stopServer() {
		threadServer.interrupt();
		synchronized (clientHandlersList) {
			for (ClientHandler clientHandler : clientHandlersList) {
				clientHandler.setServerStopped();
			}
		}
		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			view.showErrorDialog(e.getMessage());
		}
		view.dispose();
	}

	/**
	 * Accepts client.
	 */
	private Socket acceptClient() {
		try {
			Socket clientSocket = serverSocket.accept();
			view.appendMessageToConsole(">> A new client accepted");
			return clientSocket;
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
		return null;
	}
}
