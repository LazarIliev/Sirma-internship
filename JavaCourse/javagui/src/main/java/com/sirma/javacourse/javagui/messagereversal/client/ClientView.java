package com.sirma.javacourse.javagui.messagereversal.client;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

/**
 * Represents the user interface for the client in the server-client application.
 */
public class ClientView extends JFrame implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Client";
	public static final String CONNECT_MESSAGE = "Connect";
	public static final String SEND_MESSAGE = "Send";
	private static final int WINDOW_WIDTH = 450;
	private static final int WINDOW_HEIGHT = 250;
	private JButton connectButton;
	private JButton sendButton;
	private JTextField field;
	private JTextArea consoleArea;
	private Client client;
	private MementoCaretaker mementoCaretaker;

	/**
	 * Creates a new user interface for the client.
	 */
	public ClientView() {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		connectButton = new JButton(CONNECT_MESSAGE);
		consoleArea = new JTextArea(5, 20);

		DefaultCaret caret = (DefaultCaret) consoleArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(consoleArea);
		consoleArea.setEditable(false);

		field = new JTextField(25);
		field.addKeyListener(this);
		sendButton = new JButton(SEND_MESSAGE);
		sendButton.setEnabled(false);

		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.add(connectButton);

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(field);
		bottomPanel.add(sendButton);

		add(topPanel, BorderLayout.PAGE_START);
		add(scrollPane, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.PAGE_END);

		connectButton.addActionListener(this);
		sendButton.addActionListener(this);

		setVisible(true);

		mementoCaretaker = new MementoCaretaker();
	}

	public String getConsoleArea() {
		return consoleArea.getText();
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
	 * Returns the {@code JButton} for connecting to the server.
	 *
	 * @return the button for connecting to the server
	 */
	public Component getConnectButton() {
		return connectButton;
	}

	/**
	 * Returns the {@code JButton} for sending a message to the server.
	 *
	 * @return the button for sending a message to the server
	 */
	public Component getSendButton() {
		return sendButton;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CONNECT_MESSAGE)) {
			connectButton.setEnabled(false);
			sendButton.setEnabled(true);

			client = new Client(this);
			client.receiveConnectedMessage();
		} else if (e.getActionCommand().equals(SEND_MESSAGE)) {
			String message = field.getText();
			if (!message.isEmpty()) {
				client.setMessage(message);
				mementoCaretaker.addMemento(new MessageMemento(message));
				field.setText("");
			}
		}
		field.requestFocus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			MessageMemento memento = mementoCaretaker.getPreviousMemento();
			if (memento != null) {
				field.setText(memento.getMessage());
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			MessageMemento memento = mementoCaretaker.getNextMemento();
			if (memento != null) {
				field.setText(memento.getMessage());
			}
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			sendButton.doClick();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}
}
