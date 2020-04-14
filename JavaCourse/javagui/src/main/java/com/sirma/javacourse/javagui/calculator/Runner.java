package com.sirma.javacourse.javagui.calculator;

import javax.swing.SwingUtilities;

/**
 * Runner class for a calculator with MVC pattern.
 */
public class Runner {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			CalculatorModel model = new CalculatorModel();
			CalculatorView view = new CalculatorView();
			CalculatorController c = new CalculatorController(model, view);
			view.registerController(c);
		});
	}
}
