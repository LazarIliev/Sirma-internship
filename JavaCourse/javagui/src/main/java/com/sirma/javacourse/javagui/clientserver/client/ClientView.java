package com.sirma.javacourse.javagui.clientserver.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Represents the UI for the client. Creates a new {@code Client} which connects to a server.
 */
public class ClientView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Client";
	private static final String CONNECT_MESSAGE = "Connect";
	private static final int WINDOW_WIDTH = 400;
	private static final int WINDOW_HEIGHT = 200;
	private JTextArea consoleArea;

	/**
	 * Creates a new UI for the client.
	 */
	public ClientView() {
		super(WINDOW_TITLE);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton button = new JButton(CONNECT_MESSAGE);
		consoleArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(consoleArea);
		consoleArea.setEditable(false);

		button.addActionListener(this);

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
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CONNECT_MESSAGE)) {
				Client client = new Client(this);
				new Thread(() ->{
					try {
						client.connectToServer();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(this, e1.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}).start();
		}
	}

	/**
	 * Append message to the {@link JTextArea}.
	 *
	 * @param message to append
	 */
	public void appendMessage(String message){
		consoleArea.append(message);
	}
}
