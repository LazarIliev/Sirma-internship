package com.sirma.javacourse.javagui.clientinfo.client;

import com.sirma.javacourse.javagui.clientinfo.View;

/**
 * Represents a Client in the Client/Server application.
 */
public class Client {
	private View view;

	/**
	 * Creates a new Client with given view for the user interface.
	 *
	 * @param view the view for the user interface
	 */
	public Client(View view) {
		this.view = view;
		this.view.getButton().addActionListener(new ClientActionListener(this));
	}

	/**
	 * Make a {@link ClientListener} instance for this client and start a new thread for.
	 */
	public void startClientListener(){
		view.getButton().setEnabled(false);
		ClientListener clientListener = new ClientListener(view);
		Thread threadClient = new Thread(clientListener);
		threadClient.start();
	}
}
