package com.sirma.javacourse.chatclient.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//todo javaDocs
public class ClientModel {
	private static final Logger logger = LogManager.getLogger(ClientModel.class);
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;
	private String name;

	public ClientModel( String name, Socket socket) {
		this.name = name;
		setSocket(socket);
	}

	public String getName() {
		return name;
	}

	public BufferedReader getIn() {
		return in;
	}

	public String readLine() throws IOException {
		return in.readLine();
	}

	public PrintWriter getOut() {
		return out;
	}

	public Socket getSocket() {
		return socket;
	}

	public boolean isSocketClosed(){
		return socket.isClosed();
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
