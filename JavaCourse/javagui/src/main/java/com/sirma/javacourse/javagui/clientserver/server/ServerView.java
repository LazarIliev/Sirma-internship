package com.sirma.javacourse.javagui.clientserver.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Represents the UI for the server. Creates a new {@code ServerListener} thread and starts it.
 */
public class ServerView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Server";
	private static final String STOP_SERVER_MESSAGE = "Stop server";
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 200;
	private Server serverListener;

	/**
	 * Creates a new server UI.
	 */
	public ServerView() {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton(STOP_SERVER_MESSAGE);
		JTextArea consoleArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(consoleArea);
		consoleArea.setEditable(false);

		button.addActionListener(this);

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.add(button);

		add(panel, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
		serverListener = new Server();
		serverListener.startServer();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(STOP_SERVER_MESSAGE)) {
			serverListener.stopServer();
			dispose();
		}
	}
}
