package com.sirma.javacourse.javagui.calculator;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * The view of the calculator. It knows only about controller.
 */
public class CalculatorView extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String WINDOW_TITLE = "Calculator";
	private final String[][] buttons = { { "1", "2", "3", "/" }, { "4", "5", "6", "*" },
			{ "7", "8", "9", "-" }, { "0", ".", "=", "+" } };
	private CalculatorController controller;
	private JTextField field;
	private GridBagConstraints constraints;

	/**
	 * Creates a new view.
	 */
	public CalculatorView() {
		super(WINDOW_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setOperationComponents();
		createButtons();
		pack();
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Registers a controller to the view. Only one controller can be registered.
	 *
	 * @param controller the calculator controller
	 */
	public void registerController(CalculatorController controller) {
		this.controller = controller;
	}

	/**
	 * Sets the text in the text field.
	 *
	 * @param text the new text to be set
	 */
	public void setFieldText(String text) {
		field.setText(text);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.processCommand(e.getActionCommand());
	}

	/**
	 * Set the operation components for the calculator.
	 */
	private void setOperationComponents() {
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;

		field = new JTextField("0");
		field.setEditable(false);
		constraints.gridwidth = 4;
		constraints.gridheight = 2;
		constraints.ipadx = 5;
		constraints.ipady = 5;
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(field, constraints);

		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.ipadx = 5;
		constraints.ipady = 5;
		constraints.insets = new Insets(3, 3, 3, 3);

		JButton clearButton = new JButton("clear");
		clearButton.addActionListener(this);
		constraints.gridwidth = 2;
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(clearButton, constraints);

		constraints.gridwidth = 1;

		JButton backButton = new JButton("b");
		backButton.addActionListener(this);
		constraints.gridx = 2;
		constraints.gridy = 2;
		container.add(backButton, constraints);
	}

	/**
	 * Creates the buttons in the buttons matrix.
	 */
	private void createButtons() {
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				addJButton(buttons[i][j], j, i + 3);
			}
		}
	}

	/**
	 * Adds new button to the content pane. Also adds this as action listener to the created button.
	 *
	 * @param text the text of the button
	 * @param x the gridx position in the GridBagLayout
	 * @param y the gridy position in the GridBagLayout
	 */
	private void addJButton(String text, int x, int y) {
		JButton button = new JButton(text);
		constraints.gridx = x;
		constraints.gridy = y;
		getContentPane().add(button, constraints);
		button.addActionListener(this);
	}
}
