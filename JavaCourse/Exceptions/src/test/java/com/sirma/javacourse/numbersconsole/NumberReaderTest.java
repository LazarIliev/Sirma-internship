package com.sirma.javacourse.numbersconsole;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NumberReaderTest {

	@Test
	void NumberReaderConstructor_withInvalidNumber_shouldThrowException() {
		assertThrows(NumberNotInIntervalException.class, () -> {
			int number = 101;
			new NumberReader(number);
		});
	}
}