package com.sirma.javacourse.chatclient.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sirma.javacourse.chatclient.models.LoginInputModel;
import com.sirma.javacourse.chatclient.views.LoginView;

class LoginControllerTest {
	private LoginController loginController;
	private LoginView loginView;

	@BeforeEach
	void setUp(){
		loginView = mock(LoginView.class);
		loginController = new LoginController(loginView);
	}

	@Test
	void loginClient_withEmptyNickname_should() {
		LoginInputModel loginInputModel = new LoginInputModel();
		loginInputModel.setNickname("");

		loginController.loginClient(loginInputModel);

		verify(loginView, times(1)).showNoticeDialog("Nickname is required!");
	}


	@Test
	void loginClient_withWhiteSpaceForNickname_should() {
		LoginInputModel loginInputModel = new LoginInputModel();
		loginInputModel.setNickname(" ");

		loginController.loginClient(loginInputModel);

		verify(loginView, times(1)).showNoticeDialog("Nickname is required!");
	}

	@Test
	void loginClient_withTooLongNickname_should() {
		LoginInputModel loginInputModel = new LoginInputModel();
		loginInputModel.setNickname("advtrpasledwtrpa");

		loginController.loginClient(loginInputModel);

		verify(loginView, times(1)).showNoticeDialog("Nickname is too long!");
	}

	@Test
	void loginClient_withSpecialSymbolInNickname_should() {
		LoginInputModel loginInputModel = new LoginInputModel();
		loginInputModel.setNickname("Nik*");

		loginController.loginClient(loginInputModel);

		verify(loginView, times(1)).showNoticeDialog("Nickname contain a forbidden symbol!");
	}//todo multiple input for the nickname


	@Test
	void loginClient_withEmptyIpAddress_should() {
		LoginInputModel loginInputModel = new LoginInputModel();
		loginInputModel.setNickname("Niko");
		loginInputModel.setIpAddress("");

		loginController.loginClient(loginInputModel);

		verify(loginView, times(1)).showNoticeDialog("Host address is required!");
	}

	@Test
	void loginClient_withEmptyPort_should() {
		LoginInputModel loginInputModel = new LoginInputModel();
		loginInputModel.setNickname("Niko");
		loginInputModel.setIpAddress("localhost");
		loginInputModel.setPortString("");

		loginController.loginClient(loginInputModel);

		verify(loginView, times(1)).showNoticeDialog("Port number is required!");
	}

	@Test
	void loginClient_withLetterIntoPort_should() {
		LoginInputModel loginInputModel = new LoginInputModel();
		loginInputModel.setNickname("Niko");
		loginInputModel.setIpAddress("localhost");
		loginInputModel.setPortString("12s");

		loginController.loginClient(loginInputModel);

		verify(loginView, times(1)).showErrorDialog("For input string: \"12s\"");
	}
}