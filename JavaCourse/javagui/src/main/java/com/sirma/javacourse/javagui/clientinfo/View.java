package com.sirma.javacourse.javagui.clientinfo;

import javax.swing.JButton;

/**
 * Defines a contract for changing an User Interface's behavior.
 */
public interface View {
	/**
	 * Appends a given message to UI component.
	 *
	 * @param message message to be appended to a UI component
	 */
	void appendMessageToConsole(String message);

	/**
	 * Shows an error dialog with given message.
	 *
	 * @param message message to be shown in the error dialog
	 */
	void showErrorDialog(String message);

	/**
	 * Returns a {@code JButton}.
	 *
	 * @return Returns a {@code JButton}.
	 */
	JButton getButton();

	/**
	 * Closes the UI.
	 */
	void disposeView();
}
