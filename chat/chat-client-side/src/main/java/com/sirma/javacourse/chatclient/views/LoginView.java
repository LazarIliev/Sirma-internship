package com.sirma.javacourse.chatclient.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

import com.sirma.javacourse.chatclient.controllers.LoginController;
import com.sirma.javacourse.chatclient.internationalization.InternationalizationKeys;
import com.sirma.javacourse.chatclient.internationalization.LanguageBundleClientSingleton;
import com.sirma.javacourse.chatclient.models.LoginInputModel;
import com.sirma.javacourse.chatclient.utils.ClientConfig;

/**
 *
 */
public class LoginView extends JFrame implements ActionListener {
	private static final String LOGIN_BUTTON_ACTION_COMMAND = "login";
	private static final String LANG_LIST_ACTION_COMMAND = "langList";
	private static final String ENGLISH_STRING = "English";
	private ResourceBundle clientLoginBundle = LanguageBundleClientSingleton.getClientLoginBundleInstance();
	private String language = ClientConfig.AVAILABLE_LANGUAGES[0];

	private JLabel labelHostAddress;
	private JTextField hostAddress;
	private JLabel labelPort;
	private JTextField port;
	private JLabel labelNicknameField;
	private JTextField nicknameField;
	private JButton loginButton;
	private JComboBox<?> langList;

	private LoginInputModel loginInputModel;
	private LoginController loginController;

	/**
	 *
	 */
	public LoginView() {
		createLoginViewGUI();

		this.loginController = new LoginController(this);
		this.loginInputModel = new LoginInputModel();
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
	 * Shows a notice dialog with given message.
	 *
	 * @param message the message to be shown in the notice dialog
	 */
	public void showNoticeDialog(String message) {
		JOptionPane.showMessageDialog(this, message, "Notice", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Closes this login form.
	 */
	public void disposeView() {
		this.dispose();
	}


	/**
	 * Invoked when an action occurs.
	 *
	 * @param e the event to be processed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals(LOGIN_BUTTON_ACTION_COMMAND)){
				loginInputModel.setNickname(nicknameField.getText());//todo validation and after that login
				loginInputModel.setIpAddress(hostAddress.getText());
				loginInputModel.setPortString(port.getText());
				loginController.loginClient(loginInputModel);
			} else if (e.getActionCommand().equals(LANG_LIST_ACTION_COMMAND)){
				JComboBox<?> cb = (JComboBox<?>) e.getSource();
				language = (String) cb.getSelectedItem();
				setLanguage();
			}
	}

	/**
	 * Sets the language.
	 */
	private void setLanguage() {
		ResourceBundle.clearCache();
		if (ENGLISH_STRING.equals(language)) {
			LanguageBundleClientSingleton.setClientLoginLocale(Locale.US);
			LanguageBundleClientSingleton.setClientLocale(Locale.US);
		} else {
			LanguageBundleClientSingleton.setClientLoginLocale(new Locale("bg", "BG"));
			LanguageBundleClientSingleton.setClientLocale(new Locale("bg", "BG"));
		}
		clientLoginBundle = LanguageBundleClientSingleton.getClientLoginBundleInstance();
		onLocaleChange();
	}

	/**
	 * Updates the text of the UI elements. Must be invoked when the locale is changed.
	 */
	private void onLocaleChange() {
		setTitle(clientLoginBundle.getString(InternationalizationKeys.LOGIN_TITLE_MESSAGE));
		labelNicknameField.setText(clientLoginBundle.getString(InternationalizationKeys.LOGIN_LABEL_ENTER_NICKNAME));
		labelHostAddress.setText(clientLoginBundle.getString(InternationalizationKeys.LOGIN_LABEL_ENTER_HOST_ADDRESS));
		labelPort.setText(clientLoginBundle.getString(InternationalizationKeys.LOGIN_LABEL_ENTER_PORT));
		loginButton.setText(clientLoginBundle.getString(InternationalizationKeys.LOGIN_CLIENT_BUTTON));
	}

	private void createLoginViewGUI(){
		setTitle(clientLoginBundle.getString(InternationalizationKeys.LOGIN_TITLE_MESSAGE));
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);//todo?
		setLayout(new GridBagLayout());

		createButtons();
		createComboBoxes();
		createLabels();
		createFields();

		GridBagConstraints constraints = new GridBagConstraints();

		createRowView(constraints, 10, 0, labelHostAddress);
		createRowViewTextField(constraints, 10, 1, hostAddress);
		createRowView(constraints, 10, 2, labelPort);
		createRowViewTextField(constraints, 10, 3, port);
		createRowView(constraints, 10, 4, labelNicknameField);
		createRowViewTextField(constraints, 10, 5, nicknameField);

		constraints.insets = new Insets(10, 0, 0, 0);
		constraints.ipady = 0;
		constraints.gridx = 0;
		constraints.gridy = 6;
		getContentPane().add(langList, constraints);

		constraints.insets = new Insets(10, 0, 0, 0);
		constraints.ipady = 0;
		constraints.gridx = 0;
		constraints.gridy = 7;
		getContentPane().add(loginButton, constraints);

		setVisible(true);
	}


	/**
	 * Creates the buttons.
	 */
	private void createButtons() {
		loginButton = new JButton(clientLoginBundle.getString(InternationalizationKeys.LOGIN_CLIENT_BUTTON));
		loginButton.setActionCommand(LOGIN_BUTTON_ACTION_COMMAND);
		loginButton.addActionListener(this);
	}

	/**
	 * Creates the combo boxes.
	 */
	private void createComboBoxes() {
		langList = new JComboBox<>(ClientConfig.AVAILABLE_LANGUAGES);//todo
		langList.setActionCommand(LANG_LIST_ACTION_COMMAND);
		langList.setSelectedIndex(0);
		langList.addActionListener(this);
	}

	/**
	 * Creates the labels of the form.
	 */
	private void createLabels() {
		labelNicknameField = new JLabel(clientLoginBundle.getString(InternationalizationKeys.LOGIN_LABEL_ENTER_NICKNAME));
		labelHostAddress = new JLabel(clientLoginBundle.getString(InternationalizationKeys.LOGIN_LABEL_ENTER_HOST_ADDRESS));
		labelPort = new JLabel(clientLoginBundle.getString(InternationalizationKeys.LOGIN_LABEL_ENTER_PORT));
	}

	/**
	 * Creates the fields of the form.
	 */
	private void createFields() {
		nicknameField = new JTextField(20);
		nicknameField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButton.doClick();
				}
			}
		});

		hostAddress = new JTextField(20);
		port = new JTextField(20);
	}

	private void createRowView(GridBagConstraints constraints, int ipady, int gridy, JLabel jLabel){
		constraints.insets = new Insets(0, 0 , 0, 0);
		constraints.ipady = ipady;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = gridy;
		getContentPane().add(jLabel, constraints);
	}
	private void createRowViewTextField(GridBagConstraints constraints, int ipady, int gridy, JTextField jTextField) {
		constraints.insets = new Insets(0, 0 , 0, 0);
		constraints.ipady = ipady;
		constraints.gridx = 0;
		constraints.gridy = gridy;
		getContentPane().add(jTextField, constraints);
	}
}
