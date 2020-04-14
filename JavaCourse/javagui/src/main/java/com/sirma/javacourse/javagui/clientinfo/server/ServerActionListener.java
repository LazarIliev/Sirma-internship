package com.sirma.javacourse.javagui.clientinfo.server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens for the stop button from the server. When pressed it stops the server.
 */
public class ServerActionListener implements ActionListener {
	private Server server;

	/**
	 * Creates a new action listener with given server which to stop when the event is triggered.
	 *
	 * @param server the server which to stop when the event is triggered
	 */
	public ServerActionListener(Server server) {
		this.server = server;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		server.stopServer();
	}
}
