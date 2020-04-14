package com.sirma.javacourse.javagui.transmitter.server;

import static java.lang.Thread.sleep;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.javagui.transmitter.MulticastingElements;

/**
 * Represents the multi-casting socket.
 */
public class MulticastSocket extends DatagramSocket implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(MulticastSocket.class);
	private static final int ONE_SECOND_IN_MILLISECONDS = 1000;
	private MessageGenerator messageGenerator;
	private ChannelMediator channelMediator;
	private ServerView view;
	private boolean isStopped = false;

	/**
	 * Creates a new multicast socket with given user interface for the server.
	 *
	 * @param view the user interface of the server
	 */
	public MulticastSocket(ServerView view) throws SocketException {
		super();
		this.messageGenerator = new MessageGenerator();
		this.channelMediator = new ChannelMediator();
		this.view = view;
	}

	/**
	 * Stops the server.
	 */
	public void stopTransmitting() {
		isStopped = true;
		try {
			sendMessage(MulticastingElements.STRING_CHANNEL_IP, true);
			sendMessage(MulticastingElements.INTEGER_CHANNEL_IP, true);
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		while (!isStopped) {
			try {
				String channel = channelMediator.getChannel();
				sendMessage(channel, false);

				sleep(ONE_SECOND_IN_MILLISECONDS);
			} catch (IOException | InterruptedException e) {
				isStopped = true;
				logger.info(e.getMessage(), e);
			}
		}
		closeSocket();
	}

	/**
	 * Sends a message through the socket.
	 *
	 * @throws IOException if there is some problem with the socket
	 */
	public void sendMessage(String channel, boolean isEndOfServer) throws IOException {
		String message = "";
		if (isEndOfServer) {
			message = MulticastingElements.END_OF_SERVER;
		} else {
			message = getMessage(channel) + " -> send by " + channel;
		}

		view.appendMessageToConsole(">> Sent message on channel: " + channel);

		byte[] buffer = message.getBytes();
		InetAddress group = InetAddress.getByName(channel);

		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group,
				MulticastingElements.MULTICAST_PORT);

		send(packet);
	}

	/**
	 * Close the socket.
	 */
	public void closeSocket() {
		close();
	}

	/**
	 * Returns a message depending on the channel.
	 *
	 * @param channel the channel
	 * @return a message for the channel
	 */
	private String getMessage(String channel) {
		if (channel.equals(MulticastingElements.STRING_CHANNEL_IP)) {
			return messageGenerator.generateString();
		} else {
			return messageGenerator.generateInt();
		}
	}
}