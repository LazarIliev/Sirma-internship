package com.sirma.javacourse.chatclient.main;

import javax.swing.*;

import com.sirma.javacourse.chatclient.views.LoginView;

public class RunnerClient {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(LoginView::new);
	}
}
