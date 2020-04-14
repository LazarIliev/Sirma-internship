package com.sirma.javacourse.intro.randomstringswithgivenlength;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomStringGenerateTest {

	@Test
	void getAlphaNumericString_withGivenLength_ShouldReturnRandomStringWithTheGivenLength() {
		int length = 15;

		String randomStr = RandomStringGenerator.getAlphaNumericString(length);
		int expectedLength = randomStr.length();

		Assertions.assertEquals(expectedLength, length);
	}

	@Test
	void getAlphaNumericString_withZeroLength_ShouldReturnCorrectResult() {
		int length = 0;

		Assertions.assertThrows(InvalidParameterException.class,
				() -> {RandomStringGenerator.getAlphaNumericString(length);});
	}

	@Test
	void getAlphaNumericString_withNegativeLength_ShouldReturnCorrectResult() {
		int length = -20;

		Assertions.assertThrows(InvalidParameterException.class,
				() -> {RandomStringGenerator.getAlphaNumericString(length);});
	}
}