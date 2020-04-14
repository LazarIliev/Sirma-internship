package com.sirma.javacourse.chatserver.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

import com.sirma.javacourse.chatserver.internationalization.InternationalizationKeys;
import com.sirma.javacourse.chatserver.internationalization.LanguageBundleServerSingleton;
import com.sirma.javacourse.chatserver.server.ServerController;
import com.sirma.javacourse.chatserver.utils.Date;
import com.sirma.javacourse.chatserver.utils.ServerConfig;

//todo javaDoc
/**
 *
 */
public class ServerView extends JFrame implements ActionListener {
	private static final String LANG_LIST_ACTION_COMMAND = "langList";
	private static final String PORT_LIST_ACTION_COMMAND = "portList";
	private static final String NEW_LINE = System.lineSeparator();
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 400;
	private static final int ONLINE_CLIENTS_LIST_WIDTH = 180;

	private JList<String> onlineClientsList;
	private DefaultListModel<String> onlineClientsListModel;
	private JButton stopButton;
	private JButton startButton;
	private JTextArea consoleArea;
	private JLabel labelLang;
	private JLabel labelPort;
	private JComboBox<?> portList;
	private JComboBox<?> langList;
	private JScrollPane consoleScrollPane;
	private JScrollPane listScrollPane;

	private ResourceBundle serverBundle = LanguageBundleServerSingleton.getServerBundleInstance();
	private int port = Integer.parseInt(ServerConfig.SERVER_PORTS[0]);
	private String language = "English";

	private ServerController serverController;

	/**
	 *
	 */
	public ServerView() {
		createServerViewGUI();
	}

	/**
	 * Append a message to the server's console interface.
	 */
	public void appendMessageToConsole(String message) {
		String date = Date.getCurrentDate(Date.SIMPLE_TIME_DATE_FORMAT);
		String formattedMessage = String.format("[%s]: %s%s", date, message, NEW_LINE);
		consoleArea.append(formattedMessage);
	}

	/**
	 * Add a client to online client list.
	 */
	public void addOnlineClient(String nickname) {
		onlineClientsListModel.addElement(nickname);
	}

	/**
	 * Remove a client from online clients list.
	 */
	public void removeOnlineClient(String nickname) {
		onlineClientsListModel.removeElement(nickname);
	}

	/**
	 * Clear online clients list.
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
		if (LANG_LIST_ACTION_COMMAND.equals(cmd) || PORT_LIST_ACTION_COMMAND.equals(cmd)) {
			JComboBox<?> cb = (JComboBox<?>) e.getSource();
			if (LANG_LIST_ACTION_COMMAND.equals(cmd)) {
				language = (String) cb.getSelectedItem();
				changeLanguage();
			} else {
				String stringPort = (String) cb.getSelectedItem();
				assert stringPort != null;
				port = Integer.parseInt(stringPort);
			}
		} else if (serverBundle.getString(InternationalizationKeys.SERVER_START_BUTTON).equals(cmd)) {
			serverController = new ServerController(this, port);
			serverController.startServer();
			resetServerGUIButtonPressed(false, true, false);
		} else if (serverBundle.getString(InternationalizationKeys.SERVER_STOP_BUTTON).equals(cmd)) {
			serverController.stopServer();
			resetServerGUIButtonPressed(true, false, true);
			langList.setEnabled(true);
		}
	}

	private void createServerViewGUI(){
		setTitle(serverBundle.getString(InternationalizationKeys.SERVER_TITLE_MESSAGE));
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createButtons();
		createLabels();
		createComboBoxes();
		createTextArea();
		createOnlineClientsList();
		setOnWindowClosing();

		initializeAndSetConsoleScrollPane();
		initializeAndSetListScrollPane();

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(startButton);
		bottomPanel.add(stopButton);

		JPanel topPanel = new JPanel();
		topPanel.add(labelLang);
		topPanel.add(langList);
		topPanel.add(labelPort);
		topPanel.add(portList);

		setLayout(new BorderLayout());
		add(topPanel, BorderLayout.PAGE_START);
		add(consoleScrollPane, BorderLayout.CENTER);
		add(listScrollPane, BorderLayout.EAST);
		add(bottomPanel, BorderLayout.PAGE_END);

		setVisible(true);
	}

	private void resetServerGUIButtonPressed(boolean startButton, boolean stopButton, boolean port){
		this.startButton.setEnabled(startButton);
		this.stopButton.setEnabled(stopButton);
		this.portList.setEnabled(port);
	}

	/**
	 * Changes the language of the server ui.
	 */
	private void changeLanguage() {
		ResourceBundle.clearCache();
		if (ServerConfig.AVAILABLE_LANGUAGES[0].equals(language)) {
			LanguageBundleServerSingleton.setServerLocale(Locale.US);
		} else {
			LanguageBundleServerSingleton.setServerLocale(new Locale("bg", "BG"));
		}
		serverBundle = LanguageBundleServerSingleton.getServerBundleInstance();
		onLocaleChange();
	}

	/**
	 * Updates the text of the UI elements. Must be invoked when the locale is changed.
	 */
	private void onLocaleChange() {
		TitledBorder consoleBorder = BorderFactory.createTitledBorder(serverBundle
				.getString(InternationalizationKeys.SERVER_CONSOLE_MESSAGE));
		consoleBorder.setTitleJustification(TitledBorder.LEFT);
		consoleScrollPane.setBorder(consoleBorder);

		TitledBorder onlineClientsBorder = BorderFactory.createTitledBorder(serverBundle
				.getString(InternationalizationKeys.ONLINE_CLIENTS_MESSAGE));
		onlineClientsBorder.setTitleJustification(TitledBorder.CENTER);
		listScrollPane.setBorder(onlineClientsBorder);

		setTitle(serverBundle.getString(InternationalizationKeys.SERVER_TITLE_MESSAGE));
		startButton.setText(serverBundle.getString(InternationalizationKeys.SERVER_START_BUTTON));
		stopButton.setText(serverBundle.getString(InternationalizationKeys.SERVER_STOP_BUTTON));
		labelLang.setText(serverBundle.getString(InternationalizationKeys.SERVER_CHOOSE_LANGUAGE_MESSAGE));
		labelPort.setText(serverBundle.getString(InternationalizationKeys.SERVER_CHOOSE_PORT_MESSAGE));
	}

	/**
	 * Creates the buttons.
	 */
	private void createButtons() {
		startButton = new JButton(
				serverBundle.getString(InternationalizationKeys.SERVER_START_BUTTON));
		startButton.addActionListener(this);

		stopButton = new JButton(serverBundle.getString(InternationalizationKeys.SERVER_STOP_BUTTON));
		stopButton.addActionListener(this);
		stopButton.setEnabled(false);
	}

	/**
	 * Initializes the labels.
	 */
	private void createLabels() {
		labelLang = new JLabel(serverBundle.getString(InternationalizationKeys.SERVER_CHOOSE_LANGUAGE_MESSAGE));
		labelPort = new JLabel(serverBundle.getString(InternationalizationKeys.SERVER_CHOOSE_PORT_MESSAGE));
	}

	/**
	 * Creates the combo boxes.
	 */
	private void createComboBoxes() {
		langList = new JComboBox<>(ServerConfig.AVAILABLE_LANGUAGES);
		langList.setActionCommand(LANG_LIST_ACTION_COMMAND);
		langList.setSelectedIndex(0);
		langList.addActionListener(this);

		portList = new JComboBox<>(ServerConfig.SERVER_PORTS);
		portList.setActionCommand(PORT_LIST_ACTION_COMMAND);
		portList.setSelectedIndex(0);
		portList.addActionListener(this);
	}

	/**
	 * Creates the text areas.
	 */
	private void createTextArea() {
		consoleArea = new JTextArea(5, 20);
		consoleArea.setEditable(false);
		consoleArea.setLineWrap(true);
		DefaultCaret consoleCaret = (DefaultCaret) consoleArea.getCaret();
		consoleCaret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	}

	/**
	 * Creates the lists in the view.
	 */
	private void createOnlineClientsList() {
		onlineClientsListModel = new DefaultListModel<>();
		onlineClientsList = new JList<>(onlineClientsListModel);
		onlineClientsList.setFixedCellWidth(ONLINE_CLIENTS_LIST_WIDTH);
	}

	private void initializeAndSetConsoleScrollPane() {
		consoleScrollPane = new JScrollPane();
		consoleScrollPane.setViewportView(consoleArea);

		TitledBorder consoleBorder = BorderFactory.createTitledBorder(
				serverBundle.getString(InternationalizationKeys.SERVER_CONSOLE_MESSAGE));
		consoleBorder.setTitleJustification(TitledBorder.LEFT);
		consoleScrollPane.setBorder(consoleBorder);
	}

	private void initializeAndSetListScrollPane() {
		listScrollPane = new JScrollPane(onlineClientsList);
		TitledBorder onlineClientsBorder = BorderFactory.createTitledBorder(
				serverBundle.getString(InternationalizationKeys.ONLINE_CLIENTS_MESSAGE));
		onlineClientsBorder.setTitleJustification(TitledBorder.CENTER);
		listScrollPane.setBorder(onlineClientsBorder);
	}

	/**
	 * Sets the server to stop on closing the window.
	 */
	private void setOnWindowClosing() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (serverController != null) {
					serverController.stopServer();
				}
				super.windowClosing(e);
			}
		});
	}
}
