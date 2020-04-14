package com.sirma.javacourse.designpatterns.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	private Calculator calculator = new Calculator();

	@Test
	void calc_withSimpleInput_shouldWork() {
		String input = "2+2-3";
		String expected = "1.0";

		String actual = calculator.calc(input);

		assertEquals(expected, actual);
	}

	@Test
	void calc_inputWithBrackets_shouldWork() {
		String input = "2+2-(3+9)";
		String expected = "-8.0";

		String actual = calculator.calc(input);

		assertEquals(expected, actual);
	}

	@Test
	void calc_inputWithBracketsAndMultiplication_shouldWork() {
		String input = "2+2-(3+9)*2";
		String expected = "-20.0";

		String actual = calculator.calc(input);

		assertEquals(expected, actual);
	}

	@Test
	void calc_inputWithBracketsAndDivision_shouldWork() {
		String input = "2+2-(3+9)/2";
		String expected = "-2.0";

		String actual = calculator.calc(input);

		assertEquals(expected, actual);
	}

	@Test
	void calc_inputWithBracketsAndPower_shouldWork() {
		String input = "2+2-(3+9)^2";
		String expected = "-140.0";

		String actual = calculator.calc(input);

		assertEquals(expected, actual);
	}
}
