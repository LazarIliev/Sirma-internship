package com.sirma.javacourse.javagui.messagereversal.server;

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

class ClientHandlerTest {
	@InjectMocks
	private ClientHandler clientHandler;
	@Mock
	private PrintWriter writer;
	@Mock
	private BufferedReader reader;

	private String message = "some message";

	@BeforeEach
	void setUp() throws IOException {
		ServerView view = Mockito.mock(ServerView.class);
		Socket socket = Mockito.mock(Socket.class);
		OutputStream outputStream  = Mockito.mock(OutputStream.class);
		Mockito.when(socket.getOutputStream()).thenReturn(outputStream);
		InputStream inputStream = Mockito.mock(InputStream.class);
		Mockito.when(socket.getInputStream()).thenReturn(inputStream);
		clientHandler = new ClientHandler(socket, view);
		MockitoAnnotations.initMocks(this);
	}


	@Test
	void readClientMessage_withNormalWorkFlow_shouldWork() throws IOException {
		Mockito.when(reader.readLine()).thenReturn(message);

		String actual = clientHandler.readClientMessage();

		assertEquals(message, actual);
	}


	@Test
	void writeMessage_withNormalWorkFlow_shouldWork(){
		clientHandler.writeMessage(message);
		Mockito.verify(writer, Mockito.times(1)).println(message);
	}
}