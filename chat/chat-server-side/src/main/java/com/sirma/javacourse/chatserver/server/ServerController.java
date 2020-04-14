package com.sirma.javacourse.chatserver.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.javacourse.chatserver.view.ServerView;

/**
 *
 */
public class ServerController implements Runnable {
	private static final Logger logger = LogManager.getLogger(ServerController.class);
	private ArrayList<String> userNames;
	private ArrayList<PrintWriter> printWriters;
	private ServerView serverView;
	private int port;
	private ServerSocket serverSocket;
	private ArrayList<ConversationHandler> conversationHandlers;

	/**
	 *
	 * @param serverView
	 * @param port
	 */
	public ServerController(ServerView serverView, int port) {
		this.serverView = serverView;
		this.port = port;
		this.conversationHandlers = new ArrayList<>();
		this.userNames = new ArrayList<>();
		this.printWriters = new ArrayList<>();
	}

	public ArrayList<String> getUserNames() {
		return userNames;
	}

	public ArrayList<PrintWriter> getPrintWriters() {
		return printWriters;
	}

	/**
	 *
	 */
	public void startServer() {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		serverView.appendMessageToConsole("Server has started at port: " + port);
		Thread serverThread = new Thread(this);
		serverThread.start();
	}

	public void stopServer() {
		for (ConversationHandler conversationHandler : conversationHandlers) {
			conversationHandler.closeSocket();
		}

		serverView.clearOnlineClientsList();
		conversationHandlers.clear();
		userNames.clear();
		try {
			serverSocket.close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		serverView.appendMessageToConsole("Server has stopped!");
	}

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		while (!serverSocket.isClosed()) {
			try {
				Socket soc = serverSocket.accept();
				ConversationHandler handler = new ConversationHandler(soc, this);
				new Thread(handler).start();
				conversationHandlers.add(handler);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	public void addOnlineClient(String name) {
		serverView.addOnlineClient(name);
	}

	public void removeOnlineClient(String name) {
		serverView.removeOnlineClient(name);
	}

	public void appendMessageServerViewConsole(String message) {
		serverView.appendMessageToConsole(message);
	}
}
