package com.sirma.javacourse.javagui.clientinfo.client;

import com.sirma.javacourse.javagui.clientinfo.View;

/**
 * Starts a new Client.
 */
public final class RunClient {
	public static void main(String[] args) {
		View view = new ClientView();
		new Client(view);
	}
}