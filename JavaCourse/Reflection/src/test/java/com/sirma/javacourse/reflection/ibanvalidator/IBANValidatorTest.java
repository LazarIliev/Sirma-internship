package com.sirma.javacourse.reflection.ibanvalidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IBANValidatorTest {

	@Test
	void validateIBANS_withCorrectData_shouldWork() {
		String actual = IBANValidator.validateIBANS("<iban>BG80 BNBG 9661 1020 3456 7843</iban>");
		String expected = "<iban>****7843</iban>";

		assertEquals(expected, actual);
	}

	@Test
	void validateIBANS_withIncorrectData_shouldNotWork() {
		String actual = IBANValidator.validateIBANS("<iban>8080 BNBG 9661 1020 3456 7843</iban>");
		String expected = "<iban>8080 BNBG 9661 1020 3456 7843</iban>";

		assertEquals(expected, actual);
	}
}