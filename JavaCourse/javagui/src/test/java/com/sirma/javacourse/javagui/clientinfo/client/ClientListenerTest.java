package com.sirma.javacourse.javagui.clientinfo.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sirma.javacourse.javagui.clientinfo.View;
import com.sirma.javacourse.javagui.utils.SocketUtils;

class ClientListenerTest {

	@InjectMocks
	private ClientListener clientListener;
	@Mock
	private Socket socket;
	@Mock
	private BufferedReader reader;

	View view;

	@BeforeEach
	public void setUp() throws IOException {
		 view = Mockito.mock(View.class);
		SocketUtils.openServerSocket();
		clientListener = new ClientListener(view);
		MockitoAnnotations.initMocks(this);
	}


	@Test
	void appendMessageToConsole_shouldBeInvoked() throws IOException {
		InputStream inputStream = Mockito.mock(InputStream.class);
		Mockito.when(socket.getInputStream()).thenReturn(inputStream);
		Mockito.when(reader.readLine()).thenReturn("end");

		clientListener.run();

		Mockito.verify(view, Mockito.times(1)).appendMessageToConsole("Connected to the server...");
		Mockito.verify(view, Mockito.times(1)).appendMessageToConsole("end");
	}
}