package com.sirma.javacourse.javagui.transmitter;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.net.SocketException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sirma.javacourse.javagui.transmitter.client.ClientView;
import com.sirma.javacourse.javagui.transmitter.client.MulticastClient;
import com.sirma.javacourse.javagui.transmitter.server.MulticastSocket;
import com.sirma.javacourse.javagui.transmitter.server.ServerView;

class MulticastClientTest {
	private ServerView serverView = mock(ServerView.class);
	private MulticastSocket server = new MulticastSocket(serverView);
	private ClientView clientView = mock(ClientView.class);

	MulticastClientTest() throws SocketException {}

	@Test
	void receiveMessage_fromServerStringChannel_shouldWork() throws IOException {
		MulticastClient multicastClient = new MulticastClient(MulticastingElements.STRING_CHANNEL_NAME, clientView);

		server.sendMessage(MulticastingElements.STRING_CHANNEL_IP, false);
		String actual = multicastClient.receiveMessage();

		Assertions.assertFalse(actual.isEmpty());
		multicastClient.closeClientSocket();
		server.closeSocket();
	}

	@Test
	void receiveMessage_fromServerIntegerChannel_shouldWork() throws IOException {
		MulticastClient multicastClient = new MulticastClient(MulticastingElements.INTEGER_CHANNEL_NAME, clientView);

		server.sendMessage(MulticastingElements.INTEGER_CHANNEL_IP, false);
		String actual = multicastClient.receiveMessage();

		Assertions.assertFalse(actual.isEmpty());
		multicastClient.closeClientSocket();
		server.closeSocket();
	}
}