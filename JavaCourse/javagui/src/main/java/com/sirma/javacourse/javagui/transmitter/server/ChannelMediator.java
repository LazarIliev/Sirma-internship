package com.sirma.javacourse.javagui.transmitter.server;

import java.util.Random;

import com.sirma.javacourse.javagui.transmitter.MulticastingElements;

/**
 * Holds method which decides on what channel to send data.
 */
public class ChannelMediator {
	private Random randomGenerator = new Random();

	/**
	 * Returns one of the channel's IP address.
	 *
	 * @return IP address of randomly chosen channel
	 */
	public String getChannel() {
		String channel;
		int channelNumber = randomGenerator.nextInt(2);

		if (channelNumber == 0) {
			channel = MulticastingElements.STRING_CHANNEL_IP;
		} else {
			channel = MulticastingElements.INTEGER_CHANNEL_IP;
		}
		return channel;
	}
}
