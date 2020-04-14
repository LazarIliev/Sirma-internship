package com.sirma.javacourse.reflection.emailvalidator;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmailValidatorTest {

	@Test
	void isEmailValid_withCorrectEmail_shouldReturnTrue() {
		boolean actual = EmailValidator.isEmailValid("test.t-s@sir-ma.com");

		assertTrue(actual);
	}

	@Test
	void isEmailValid_withIncorrectEmail_shouldReturnFalse() {
		boolean actual = EmailValidator.isEmailValid("1test.t-s@sir-ma.com");

		assertFalse(actual);
	}

}