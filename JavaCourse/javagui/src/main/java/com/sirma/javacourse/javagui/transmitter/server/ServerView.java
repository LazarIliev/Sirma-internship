package com.sirma.javacourse.javagui.transmitter.server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

/**
 * Represents the user interface of the server.
 */
public class ServerView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Server";
	private static final String STOP_SERVER_MESSAGE = "Stop server";
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 200;
	private JTextArea consoleArea;
	private MulticastSocket server;

	/**
	 * Creates a new user interface for the server.
	 */
	public ServerView() {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton(STOP_SERVER_MESSAGE);

		consoleArea = new JTextArea(5, 20);
		DefaultCaret caret = (DefaultCaret) consoleArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(consoleArea);
		consoleArea.setEditable(false);

		button.addActionListener(this);

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.add(button);

		add(panel, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);

		try {
			server = new MulticastSocket(this);
		} catch (SocketException e) {
			showErrorDialog(e.getMessage());
		}
		new Thread(server).start();
	}

	/**
	 * Appends a given message to the text area.
	 *
	 * @param message the message to be appended to the text area
	 */
	public void appendMessageToConsole(String message) {
		consoleArea.append(message + System.lineSeparator());
	}

	/**
	 * Shows an error dialog with given message.
	 *
	 * @param message the message to be shown in the error dialog
	 */
	public void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(STOP_SERVER_MESSAGE)) {
			server.stopTransmitting();
			dispose();
		}
	}
}
