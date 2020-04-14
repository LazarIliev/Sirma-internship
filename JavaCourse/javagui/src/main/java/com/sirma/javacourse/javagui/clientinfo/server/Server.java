package com.sirma.javacourse.javagui.clientinfo.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.javagui.clientinfo.View;
import com.sirma.javacourse.javagui.utils.SocketUtils;

/**
 * Represents a Server in the Client/Server application. It holds a list of the connected clients.
 */
public class Server implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Server.class);
	public static final String CLOSING_SERVER_MESSAGE = "end";
	private List<Socket> clients;
	private View view;
	private Thread serverThread;
	private ServerSocket serverSocket;

	/**
	 * Creates a new Server with given view for the user interface.
	 *
	 * @param view the view for the user interface
	 */
	public Server(View view) {
		this.clients = Collections.synchronizedList(new ArrayList<>());
		this.view = view;
		this.view.getButton().addActionListener(new ServerActionListener(this));
		try {
			this.serverSocket = SocketUtils.openServerSocket();
		} catch (IOException ex) {
			logger.info(ex.getMessage(), ex);
		}
		this.serverThread = new Thread(this);
	}

	/**
	 * Gets the clients count.
	 *
	 * @return count of the clients
	 */
	public int getClientsCount() {
		return clients.size();
	}

	/**
	 * Starts the server. Creates a new {@code ServerSocket} and starts to accept clients.
	 */
	public void startServer() {
		serverThread.start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		acceptClients();
	}

	/**
	 * In an infinite loop accepts clients. For every connected client it creates a new
	 * {@code ClientNotifier} thread which notifies the other clients that a new client is
	 * connected.
	 */
	private void acceptClients() {
		try {
			view.appendMessageToConsole(">> SERVER STARTED AT PORT-" + serverSocket.getLocalPort());
			while (!serverThread.isInterrupted()) {
				Socket currentClient = serverSocket.accept();
				PrintWriter writer = new PrintWriter(currentClient.getOutputStream(), true);

				int newClientNumber = clients.size() + 1;
				view.appendMessageToConsole(">> ACCEPTED A NEW CLIENT#" + newClientNumber);
				writer.println("You are client number-" + newClientNumber);

				if (clients.size() > 1) {
					ClientNotifier clientNotifier = new ClientNotifier(clients);
					new Thread(clientNotifier).start();
				}
				clients.add(currentClient);
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}

	/**
	 * Stops the server.
	 */
	public void stopServer() {
		for (Socket clientSocket : clients) {
			try {
				clientSocket.close();
			} catch (IOException e) {
				logger.info(e.getMessage(), e);
			}
		}
		serverThread.interrupt();

		try {
			if (serverSocket != null) {
				serverSocket.close();
			}
		} catch (IOException ex) {
			logger.info(ex.getMessage(), ex);
		}
		view.disposeView();
	}
}
