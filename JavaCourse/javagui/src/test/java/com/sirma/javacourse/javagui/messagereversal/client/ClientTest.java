package com.sirma.javacourse.javagui.messagereversal.client;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.sirma.javacourse.javagui.utils.SocketUtils;

class ClientTest {
	@InjectMocks
	private Client client;
	@Mock
	private PrintWriter writer;
	@Mock
	private BufferedReader reader;
	@Mock
	private Socket socket;

	private String message = "some message";

	@BeforeEach
	void setUp() throws IOException {
		ClientView view = Mockito.mock(ClientView.class);
		socket = Mockito.mock(Socket.class);
		SocketUtils.openServerSocket();
		OutputStream outputStream  = Mockito.mock(OutputStream.class);
		Mockito.when(socket.getOutputStream()).thenReturn(outputStream);
		InputStream inputStream = Mockito.mock(InputStream.class);
		Mockito.when(socket.getInputStream()).thenReturn(inputStream);
		client = new Client(view);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void sendMessageToServer_withNormalWorkFlow_shouldWork(){
		client.sendMessageToServer(message);
		Mockito.verify(writer, Mockito.times(1)).println(message);
	}

	@Test
	void readMessageFromServer_withNormalWorkFlow_shouldWork() throws IOException {
		Mockito.when(reader.readLine()).thenReturn(message);
		String actual = client.readMessageFromServer();

		assertEquals(message, actual);
	}
}