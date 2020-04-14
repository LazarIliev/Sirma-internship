package com.sirma.javacourse.javagui.clientserver.client;

import javax.swing.SwingUtilities;



/**
 * Runner class for the Client.
 */
public class RunClient {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(ClientView::new);
	}
}