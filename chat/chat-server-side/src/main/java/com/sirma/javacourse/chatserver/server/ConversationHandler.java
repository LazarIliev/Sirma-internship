package com.sirma.javacourse.chatserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
public class ConversationHandler implements Runnable {
	private static final Logger logger = LogManager.getLogger(ConversationHandler.class);
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private ServerController serverController;

	/**
	 *
	 * @param socket
	 * @param serverController
	 */
	public ConversationHandler(Socket socket, ServerController serverController) {
		this.socket = socket;
		this.serverController = serverController;
	}

	/**
	 *
	 */
	//todo Сървърът "слуша" за клиентски връзки.
	// Когато даден клиент се свърже, сървърът прочита съобщение от тип "заявка за свързване", съдържащо въведен от потребителя nickname.
	public void run() {
		try {
			setInputOutputReaderAndWriter();
			String name = "";
			String command = in.readLine();
			if (command.startsWith("login")){
				name = command.substring(5);
				if (!serverController.getUserNames().contains(name)){
					serverController.getUserNames().add(name);
					out.println("NAMEACCEPTED");
				} else {
					out.println("NAMEALREADYEXISTS");
					closeSocket();
					return;
				}
			}else {
				out.println("WRONGCOMMAND");
				closeSocket();
				return;
			}
			serverController.addOnlineClient(name);

			for (PrintWriter writer : serverController.getPrintWriters()){
				writer.println("+++" + name); //todo writer.println(name + " has connected!");
			}//todo to extract into a new method

			out.println(serverController.getUserNames());
			out.println("Welcome server started");//todo to extract into a new method

			serverController.appendMessageServerViewConsole("New client: " + name + " has connected!");
			serverController.appendMessageServerViewConsole("Started a new thread for client: " + name);
			serverController.getPrintWriters().add(out);//todo to extract into a new method

			//----- logic after accepted new client
			//todo Връзката с потребителя е активна докато клиентът не изпрати команда за край на сесията.
			// При получаване на такава команда се извършва следното:
			String message = "";
			while (message != null) {
				message = in.readLine();
				if (message == null) {
					serverController.getPrintWriters().remove(out);//todo
					serverController.getUserNames().remove(name);
					serverController.removeOnlineClient(name);
					serverController.appendMessageServerViewConsole("Client name: " + name + " has disconnected!");
				}
				for (PrintWriter writer : serverController.getPrintWriters()) {
					if (message == null){
						writer.println("***"+ name);//+ ": " + "client " + name + " is disconnected"
					} else {
						writer.println(name + ": " + message);
					}
				}
			}//todo to extract this while into a new method
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 *
	 */
	public void closeSocket(){
		try {
			//todo to send message that server is
			socket.close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private void setInputOutputReaderAndWriter(){
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}
}
