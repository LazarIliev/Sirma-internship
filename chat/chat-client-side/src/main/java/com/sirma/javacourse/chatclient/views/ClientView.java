package com.sirma.javacourse.chatclient.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import com.sirma.javacourse.chatclient.controllers.ClientController;
import com.sirma.javacourse.chatclient.internationalization.InternationalizationKeys;
import com.sirma.javacourse.chatclient.internationalization.LanguageBundleClientSingleton;
import com.sirma.javacourse.chatclient.models.ClientModel;
import com.sirma.javacourse.chatclient.utils.Date;
import com.sirma.javacourse.chatclient.utils.DocumentLengthFilter;

/**
 *
 */
public class ClientView extends JFrame implements ActionListener {
	public static final String SEND_MESSAGE_BUTTON_ACTION_COMMAND = "send";
	public static final String LOGOUT_BUTTON_ACTION_COMMAND = "logout";
	private static final String NEW_LINE = System.lineSeparator();
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;
	private static final int ONLINE_CLIENTS_LIST_WIDTH = 180;

	private JList<String> onlineClientsList;
	private DefaultListModel<String> onlineClientsListModel;
	private JButton logoutButton;
	private JButton sendMessageButton;
	private JTextArea chatMessagesArea;
	private JTextField clientField;
	//private MementoCaretaker mementos = new MementoCaretaker();
	private ResourceBundle clientBundle = LanguageBundleClientSingleton.getClientBundleInstance();

	private ClientController clientController;

	/**
	 *
	 * @param clientModel
	 */
	public ClientView(ClientModel clientModel) {
		createClientViewGUI();

		clientController = new ClientController(clientModel, this);
		new Thread(clientController).start();

		setTitle(clientBundle.getString(InternationalizationKeys.CLIENT_TITLE_MESSAGE) + " - "
				+ clientController.getClientName());
		setVisible(true);
	}

	/**
	 *
	 */
	public void appendMessageToChatArea(String message) {
		String date = Date.getCurrentDate(Date.SIMPLE_TIME_DATE_FORMAT);
		String formattedMessage = String.format("[%s] %s%s", date, message, NEW_LINE);
		chatMessagesArea.append(formattedMessage);
	}

	/**
	 *
	 */
	public void addOnlineClient(String nickname) {
		onlineClientsListModel.addElement(nickname);
	}

	/**
	 *
	 */
	public void removeOnlineClient(String nickname) {
		onlineClientsListModel.removeElement(nickname);
	}

	/**
	 *
	 */
	public void showErrorDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 *
	 */
	public void resetUI() {
		clearOnlineClientsList();
		sendMessageButton.setEnabled(false);
		logoutButton.setEnabled(false);
	}

	/**
	 *
	 */
	public void reconnectClient() {
		sendMessageButton.setEnabled(true);
		logoutButton.setEnabled(true);
	}

	/**
	 *
	 */
	public void clearOnlineClientsList() {
		onlineClientsListModel.clear();
	}

	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (SEND_MESSAGE_BUTTON_ACTION_COMMAND.equals(cmd)) {
		// 	if (!Validator.isWhitespaceMessage(clientField.getText())) {//todo validation
		 		String message = clientField.getText();
		// 		if (!message.contains("[") && !message.contains("]")){
		// 			client.sendMessage(message);
		// 			mementos.addMemento(new MessageMemento(message));
		// 		}
			clientController.sendMessage(message);

			clientField.setText("");
			} else if (LOGOUT_BUTTON_ACTION_COMMAND.equals(cmd)){
			clientController.logout();
			dispose();
		}
	}

	private void createClientViewGUI(){
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createButtons();
		createTextAreas();
		createLists();
		createFields();
		setOnWindowClosing();

		JScrollPane consoleScrollPane = new JScrollPane();
		consoleScrollPane.setViewportView(chatMessagesArea);
		TitledBorder chatMessagesBorder = BorderFactory.createTitledBorder(clientBundle
				.getString(InternationalizationKeys.CLIENT_CHAT_TITLE_MESSAGE));
		chatMessagesBorder.setTitleJustification(TitledBorder.CENTER);
		consoleScrollPane.setBorder(chatMessagesBorder);

		JScrollPane listScrollPane = new JScrollPane(onlineClientsList);
		TitledBorder onlineClientsBorder = BorderFactory.createTitledBorder(clientBundle
				.getString(InternationalizationKeys.ONLINE_CLIENTS_MESSAGE));
		onlineClientsBorder.setTitleJustification(TitledBorder.CENTER);
		listScrollPane.setBorder(onlineClientsBorder);

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(clientField);
		bottomPanel.add(sendMessageButton);
		bottomPanel.add(logoutButton);

		setLayout(new BorderLayout());
		add(consoleScrollPane, BorderLayout.CENTER);
		add(listScrollPane, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.PAGE_END);
	}

	/**
	 * Creates the buttons.
	 */
	private void createButtons() {
		sendMessageButton = new JButton(clientBundle.getString(InternationalizationKeys.CLIENT_SEND_BUTTON));
		sendMessageButton.setActionCommand(SEND_MESSAGE_BUTTON_ACTION_COMMAND);
		sendMessageButton.addActionListener(this);

		logoutButton = new JButton(clientBundle.getString(InternationalizationKeys.CLIENT_LOGOUT_BUTTON));
		logoutButton.setActionCommand(LOGOUT_BUTTON_ACTION_COMMAND);
		logoutButton.addActionListener(this);
	}

	/**
	 * Creates the text areas.
	 */
	private void createTextAreas() {
		chatMessagesArea = new JTextArea(5, 20);
		chatMessagesArea.setEditable(false);
		chatMessagesArea.setLineWrap(true);
		DefaultCaret consoleCaret = (DefaultCaret) chatMessagesArea.getCaret();
		consoleCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}

	/**
	 * Creates the lists in the view.
	 */
	private void createLists() {
		onlineClientsListModel = new DefaultListModel<>();
		onlineClientsList = new JList<>(onlineClientsListModel);
		onlineClientsList.setFixedCellWidth(ONLINE_CLIENTS_LIST_WIDTH);
	}

	/**
	 * Creates the fields in the view.
	 */
	private void createFields() {
		clientField = new JTextField(35);
		clientField.setDocument(new DocumentLengthFilter(200));
		clientField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendMessageButton.doClick();
				}
				// } else if (e.getKeyCode() == KeyEvent.VK_UP) {
				// 	MessageMemento message = mementos.getNextMemento();
				// 	if (message != null) {
				// 		clientField.setText(message.getMessage());
				// 	}
				// } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				// 	MessageMemento message = mementos.getPreviousMemento();
				// 	if (message != null) {
				// 		clientField.setText(message.getMessage());
				// 	}
				// }
			}
		});
	}

	/**
	 * Sets to logout the client on closing the window.
	 */
	private void setOnWindowClosing() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (clientController != null) {
					clientController.logout();
				}
				super.windowClosing(e);
			}
		});
	}
}
