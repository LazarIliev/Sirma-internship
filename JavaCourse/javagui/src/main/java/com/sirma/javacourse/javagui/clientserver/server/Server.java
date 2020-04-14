package com.sirma.javacourse.javagui.clientserver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.javagui.utils.SocketUtils;

/**
 * Represents a thread. Opens a server socket and infinitely accepts clients until its stopServer
 * method is invoked.
 */
public class Server implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Server.class);
	private ServerSocket serverSocket;

	/**
	 * Starts the server.
	 */
	public void startServer() {
		try {
			serverSocket = SocketUtils.openServerSocket();
			new Thread(this).start();
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Socket socket = serverSocket.accept();
				MessageForClientTask message = new MessageForClientTask(socket);
				Thread messageThread = new Thread(message);
				messageThread.start();
			} catch (IOException e) {
				logger.info(e.getMessage(), e);
			}
		}
	}

	/**
	 * Stops the server socket from listening.
	 */
	public void stopServer() {
		if (serverSocket != null) {
			try {
				serverSocket.close();
				Thread.currentThread().interrupt();
			} catch (IOException e) {
				logger.info(e.getMessage(), e);
			}
		}
	}
}
