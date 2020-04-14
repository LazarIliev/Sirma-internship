package com.sirma.javacourse.chatclient.controllers;

import static org.mockito.Mockito.mock;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sirma.javacourse.chatclient.models.ClientModel;
import com.sirma.javacourse.chatclient.views.ClientView;

class ClientControllerTest {
	@InjectMocks
	private ClientController clientController;
	private ClientView clientView;
	@Mock
	private ClientModel clientModel;

	@BeforeEach
	void setUp() {
		clientView = mock(ClientView.class);
		clientController = new ClientController(clientModel, clientView);
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void run() throws IOException {
		Mockito.when(clientModel.readLine()).thenReturn(" online, clients ");
		Mockito.when(clientModel.isSocketClosed()).thenReturn(true);
		clientController.run();

		Mockito.verify(clientView, Mockito.times(1)).addOnlineClient("online");
		Mockito.verify(clientView, Mockito.times(1)).addOnlineClient("clients");
	}

}