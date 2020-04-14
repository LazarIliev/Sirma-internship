package com.sirma.javacourse.javagui.clientinfo.server;

import com.sirma.javacourse.javagui.clientinfo.View;

/**
 * Starts a new Server.
 */
public final class RunServer {
	public static void main(String[] args) {
		View view = new ServerView();
		new Server(view).startServer();
	}
}