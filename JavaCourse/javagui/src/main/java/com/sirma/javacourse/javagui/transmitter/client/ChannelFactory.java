package com.sirma.javacourse.javagui.transmitter.client;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.sirma.javacourse.javagui.transmitter.MulticastingElements;

public final class ChannelFactory {

	/**
	 * Protects from instantiation.
	 */
	private ChannelFactory() {

	}

	/**
	 * Creates a new {@code InetAddress} with given channel name.
	 *
	 * @param channelName the channel name which IP address will be extracted
	 * @return the {@code InetAddress} of the channel
	 * @throws UnknownHostException thrown when there is no running server
	 */
	public static InetAddress createChannelInetAddress(String channelName)
			throws UnknownHostException {
		InetAddress address;

		if (MulticastingElements.INTEGER_CHANNEL_NAME.equals(channelName)) {
			address = InetAddress.getByName(MulticastingElements.INTEGER_CHANNEL_IP);
		} else {
			address = InetAddress.getByName(MulticastingElements.STRING_CHANNEL_IP);
		}
		return address;
	}
}