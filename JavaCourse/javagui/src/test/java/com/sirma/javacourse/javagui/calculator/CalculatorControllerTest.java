package com.sirma.javacourse.javagui.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

	@Test
	public void processCommand_multiplyWithZero_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("0");
		c.processCommand("*");
		c.processCommand("2");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "0.0";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_divideOnZero_shouldError() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("2");
		c.processCommand("/");
		c.processCommand("0");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "Error";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_divideZero_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("0");
		c.processCommand("/");
		c.processCommand("2");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "0.0";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_withZero_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("0");
		c.processCommand("-");
		c.processCommand("2");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "-2.0";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_withOperationFirst_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("-");
		c.processCommand("2");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "-2.0";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_withAddition_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("2");
		c.processCommand("+");
		c.processCommand("2");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "4.0";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_withSubtract_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("2");
		c.processCommand("-");
		c.processCommand("5");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "-3.0";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_withMultiply_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("2");
		c.processCommand("*");
		c.processCommand("5");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "10.0";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_withDivide_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("20");
		c.processCommand("/");
		c.processCommand("5");
		c.processCommand("=");

		String actual = model.toString();
		String expected = "4.0";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_withClear_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("20");
		c.processCommand("/");
		c.processCommand("5");
		c.processCommand("=");
		c.processCommand("clear");

		String actual = model.toString();
		String expected = "0.0";

		assertEquals(expected, actual);
	}

	@Test
	public void processCommand_withBack_shouldWork() {
		CalculatorModel model = new CalculatorModel();
		CalculatorController c = new CalculatorController(model, null);

		c.processCommand("205");
		c.processCommand("b");

		String actual = model.toString();
		String expected = "20";

		assertEquals(expected, actual);
	}
}