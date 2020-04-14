package com.sirma.javacourse.javagui.clientserver.server;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sirma.javacourse.javagui.clientserver.client.Client;
import com.sirma.javacourse.javagui.clientserver.client.ClientView;

class ClientTest {
	private Client client;

	@BeforeEach
	void setUp() throws IOException {
		Server server = new Server();
		server.startServer();
		ClientView clientView = new ClientView();

		client = new Client(clientView);
		client.connectToServer();
	}

	@Test
	void testIfTheMessageContainsHello() {
		String actual = client.getReceivedMessage();
		String expected = "Hello!";

		assertTrue(actual.contains(expected));
	}
}