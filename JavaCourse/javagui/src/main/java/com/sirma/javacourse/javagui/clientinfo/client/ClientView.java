package com.sirma.javacourse.javagui.clientinfo.client;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sirma.javacourse.javagui.clientinfo.View;

/**
 * Represents the user interface for the Client.
 */
public class ClientView extends JFrame implements View {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Client";
	public static final String CONNECT_MESSAGE = "Connect";
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 200;
	private JButton button;
	private JTextArea consoleArea;

	/**
	 * Creates a new user interface for the client.
	 */
	public ClientView() {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton(CONNECT_MESSAGE);
		consoleArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(consoleArea);
		consoleArea.setEditable(false);

		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.add(button);

		add(panel, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void appendMessageToConsole(String message) {
		consoleArea.append(message + System.lineSeparator());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JButton getButton() {
		return button;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void disposeView() {
		dispose();
	}
}
