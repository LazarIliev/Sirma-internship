package com.sirma.javacourse.chatclient.controllers;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.javacourse.chatclient.models.ClientModel;
import com.sirma.javacourse.chatclient.utils.StringUtil;
import com.sirma.javacourse.chatclient.views.ClientView;

/**
 *
 */
public class ClientController implements Runnable{
	private static final Logger logger = LogManager.getLogger(ClientController.class);
	private ClientView clientView;
	private ClientModel clientModel;

	/**
	 *
	 * @param clientModel
	 * @param clientView
	 */
	public ClientController(ClientModel clientModel, ClientView clientView) {
		this.clientModel = clientModel;
		this.clientView = clientView;
	}

	/**
	 * Send a message to the server.
	 *
	 * @param message to be send
	 */
	public void sendMessage(String message){
		clientModel.getOut().println(StringUtil.capitalizeFirstLetter(message));
	}

	/**
	 * Get a client name.
	 *
	 * @return client name
	 */
	public String getClientName(){
		return clientModel.getName();
	}

	/**
	 * Logout a client.
	 */
	public void logout(){
		try {
			clientModel.getSocket().close();
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
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
		appendOnlineClientsToClientView();
		while (!clientModel.isSocketClosed()){
			try {
				String message = clientModel.getIn().readLine();
				if (message == null){
					clientModel.getSocket().close();
				} else if (message.startsWith("***")){
					String nameToRemove  = message.substring(3);
					clientView.appendMessageToChatArea(nameToRemove + " has been disconnected!");
					clientView.removeOnlineClient(nameToRemove);
				} else if (message.startsWith("+++")){
					String nameToAdd = message.substring(3);
					clientView.appendMessageToChatArea(nameToAdd + " has been connected!");
					clientView.addOnlineClient(nameToAdd);
				}
				else {
					clientView.appendMessageToChatArea(message);
				}
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
				return;
			}
		}
		clientView.resetUI();
		clientView.appendMessageToChatArea("Server has stopped!");
		reconnectClient();
	}

	private void appendOnlineClientsToClientView(){
		try {
			String onlineClientsStr = clientModel.readLine();
			String[] arrayOnlineClients =	onlineClientsStr.substring(1, onlineClientsStr.length() - 1).split(", ");
			for (String clientName : arrayOnlineClients){
				clientView.addOnlineClient(clientName);
			}//todo to extract into a new method
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private void reconnectClient(){
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(() ->{
			Socket socket = null;
			try {
				socket = new Socket("localhost", 7000);//todo more ports
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
			if (socket != null){//todo to check the logic if i can separate sth into a new method or simplify
				clientModel.setSocket(socket);
				clientModel.getOut().println("login" + clientModel.getName());
				try {
					clientModel.getIn().readLine();
				} catch (IOException e) {
					logger.error(e.getMessage(), e);
				}
				clientView.reconnectClient();
				new Thread(this).start();
				executor.shutdown();
			}
		}, 0, 5000, TimeUnit.MILLISECONDS);
	}
}
