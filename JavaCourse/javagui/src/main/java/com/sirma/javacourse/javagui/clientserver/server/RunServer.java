package com.sirma.javacourse.javagui.clientserver.server;

import javax.swing.SwingUtilities;

/**
 * Runner class for the server.
 */
public class RunServer {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(ServerView::new);
	}
}
