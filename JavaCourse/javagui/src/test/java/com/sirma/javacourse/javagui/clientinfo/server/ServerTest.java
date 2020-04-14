package com.sirma.javacourse.javagui.clientinfo.server;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sirma.javacourse.javagui.clientinfo.View;

class ServerTest {
	@InjectMocks
	private Server server;
	@Mock
	private View view;
	@Mock
	private Thread serverThread;
	@Mock
	private ServerSocket serverSocket;

	@BeforeEach
	public void setUp() {
		view = Mockito.mock(View.class);
		Mockito.when(view.getButton()).thenReturn(new JButton());
		server = new Server(view);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getClientsCount_withTwoSockets_shouldWork() throws IOException {
		Mockito.when(serverThread.isInterrupted())
				.thenReturn(false).thenReturn(false).thenReturn(true);
		Mockito.when(serverSocket.accept())
				.thenReturn(new Socket("localhost", 7000))
				.thenReturn(new Socket("localhost", 7000));

		server.run();

		int actual = server.getClientsCount();

		assertEquals(2, actual);
	}

	@Test
	void stopServer() throws IOException {
		Socket socket = Mockito.mock(Socket.class);
		Mockito.when(serverThread.isInterrupted())
				.thenReturn(false).thenReturn(true);
		Mockito.when(serverSocket.accept())
				.thenReturn(socket);
		OutputStream outputStream = Mockito.mock(OutputStream.class);
		Mockito.when(socket.getOutputStream()).thenReturn(outputStream);

		server.run();
		server.stopServer();

		Mockito.verify(serverSocket, Mockito.times(1)).close();
		Mockito.verify(serverThread, Mockito.times(1)).interrupt();
		Mockito.verify(socket, Mockito.times(1)).close();
	}
}