package com.sirma.javacourse.javagui.clientinfo.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens for the connect button from the server. When pressed it connects to the server.
 */
public class ClientActionListener implements ActionListener {
	private Client client;

	/**
	 * Creates a new action listener with given client.
	 *
	 * @param client the client which to connect to the server when the event is triggered
	 */
	public ClientActionListener(Client client) {
		this.client = client;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		client.startClientListener();
	}
}
