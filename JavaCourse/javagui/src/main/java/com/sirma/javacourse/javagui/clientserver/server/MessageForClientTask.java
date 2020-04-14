package com.sirma.javacourse.javagui.clientserver.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sends the current date through {@code OutputStreamWriter} in given socket.
 */
public class MessageForClientTask implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(MessageForClientTask.class);
	private static final String HELLO_MESSAGE = "Hello! ";
	private OutputStreamWriter out;

	/**
	 * Creates a new task with given socket.
	 *
	 * @param socket the socket in which the current date will be transmitted
	 * @throws IOException thrown when the server stops accepting clients
	 */
	public MessageForClientTask(Socket socket) throws IOException {
		this.out = new OutputStreamWriter(socket.getOutputStream());
	}

	/**
	 * Returns the current date as string.
	 *
	 * @return the current date as string
	 */
	public String getDateAsString() {
		return new Date().toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			out.write(HELLO_MESSAGE + getDateAsString());
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
		finally {
			try {
				out.close();
			} catch (IOException e) {
				logger.info(e.getMessage(), e);
			}
		}
	}
}
