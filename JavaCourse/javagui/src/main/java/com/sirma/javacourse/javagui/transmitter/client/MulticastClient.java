package com.sirma.javacourse.javagui.transmitter.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.javagui.transmitter.MulticastingElements;

/**
 * Represents the client.
 */
public class MulticastClient implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(MulticastClient.class);
	private MulticastSocket socket;
	private ClientView view;
	private InetAddress group;

	/**
	 * Creates a new client with given channel name and user interface of the client.
	 *
	 * @param channelName the name of the channel on which to listen
	 * @param view the user interface of the client
	 */
	public MulticastClient(String channelName, ClientView view) {
		createSocket();
		this.view = view;
		try {
			this.group = ChannelFactory.createChannelInetAddress(channelName);
			this.socket.joinGroup(group);
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				String receivedMessage = receiveMessage();
				if (receivedMessage.equals(MulticastingElements.END_OF_SERVER)) {
					view.setIsConnected(true);
					//
					Thread.currentThread().interrupt();
				}
				view.appendMessageToConsole(receivedMessage);
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		} finally {
			closeClientSocket();
		}
	}

	/**
	 * Receive the message from the socket.
	 *
	 * @return the message from the socket
	 * @throws IOException if the socket is closed
	 */
	public String receiveMessage() throws IOException {
		byte[] buffer = new byte[MulticastingElements.MIDDLE_SIZE_BUFFER];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

		socket.receive(packet);
		return new String(packet.getData(), 0, packet.getLength());
	}

	/**
	 * Close the socket of the client.
	 */
	public void closeClientSocket() {
		try {
			socket.leaveGroup(group);
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
		socket.close();
	}

	/**
	 * Instantiates the {@code MulticastSocket}.
	 */
	private void createSocket() {
		try {
			this.socket = new MulticastSocket(MulticastingElements.MULTICAST_PORT);
		} catch (IOException e) {
			view.showErrorDialog("There is no running channels");
			logger.info(e.getMessage(), e);
		}
	}
}
