package com.sirma.javacourse.javagui.clientinfo.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holds a list of connected clients to the server in a client/server application. In a thread it
 * notifies all the clients, except the newly connected client.
 */
public class ClientNotifier implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(ClientNotifier.class);
	private final List<Socket> clients;

	/**
	 * Creates a new client notifier with a given list of connected clients.
	 *
	 * @param clients list of the connected clients
	 */
	public ClientNotifier(List<Socket> clients) {
		this.clients = clients;
	}

	/**
	 * Notifies all the clients, except the newly connected client. {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			for (int i = 0; i < clients.size() - 1; i++) {
				PrintWriter writer = new PrintWriter(clients.get(i).getOutputStream(), true);
				writer.println("A new client connected - #" + clients.size());
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}
}