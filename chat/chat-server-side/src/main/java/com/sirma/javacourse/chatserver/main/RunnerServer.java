package com.sirma.javacourse.chatserver.main;

import javax.swing.*;

import com.sirma.javacourse.chatserver.view.ServerView;

public class RunnerServer {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(ServerView::new);
	}
}
