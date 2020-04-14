package com.sirma.javacourse.chatclient.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sirma.javacourse.chatclient.models.ClientModel;
import com.sirma.javacourse.chatclient.models.LoginInputModel;
import com.sirma.javacourse.chatclient.utils.Validator;
import com.sirma.javacourse.chatclient.views.ClientView;
import com.sirma.javacourse.chatclient.views.LoginView;

/**
 *
 */
public class LoginController {
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	private LoginView loginView;

	/**
	 * @param loginView
	 */
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
	}

	public void loginClient(LoginInputModel loginInputModel) {
		String nickname = loginInputModel.getNickname();
		if (nickname.isEmpty() || Validator.isWhitespaceMessage(nickname)) {
			loginView.showNoticeDialog("Nickname is required!");
			return;
		} else if (nickname.length() > Validator.MAX_NICKNAME_LENGTH){
			loginView.showNoticeDialog("Nickname is too long!");
			return;
		} else if (!Validator.isValidNickname(nickname)){
			loginView.showNoticeDialog("Nickname contain a forbidden symbol!");
			return;
		}//extract validation method

		if (loginInputModel.getIpAddress().equals("")) {
			loginView.showNoticeDialog("Host address is required!");
			return;
		}

		String ipAddress = loginInputModel.getIpAddress();

		if (loginInputModel.getPortString().equals("")) {
			loginView.showNoticeDialog("Port number is required!");
			return;
		}

		String portString = loginInputModel.getPortString();
		int port;
		try {
			port = Integer.parseInt(portString);
		} catch (NumberFormatException e) {
			loginView.showErrorDialog(e.getMessage());
			return;
		}

		Socket soc;
		try {
			soc = new Socket(ipAddress, port);
		} catch (IOException e) {
			loginView.showErrorDialog(e.getMessage());
			logger.error(e.getMessage(), e);
			return;
		}

		new Thread(() -> {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
				PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
				String name = loginInputModel.getNickname();
				out.println("login" + name);
				String serverResponse = in.readLine();
				switch (serverResponse) {
					case "NAMEACCEPTED":
						ClientModel clientModel = new ClientModel(name, soc);
						new ClientView(clientModel);
						loginView.disposeView();
						break;
					case "NAMEALREADYEXISTS":
						soc.close();
						loginView.showNoticeDialog("Name already exists!");
						break;
					case "WRONGCOMMAND":
						soc.close();
						loginView.showNoticeDialog("Something went wrong!");
						break;
				}
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}).start();
	}
}
