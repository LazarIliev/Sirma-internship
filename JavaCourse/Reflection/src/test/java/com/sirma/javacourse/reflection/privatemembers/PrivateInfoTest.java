package com.sirma.javacourse.reflection.privatemembers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

class PrivateInfoTest {
	private PrivateClass privateClass = new PrivateClass();

	@Test
	void getPrivateFields_withCorrectData_shouldWork() {
		String actual = PrivateInfo.getPrivateFields(privateClass);
		String fileName = "/privateFields.txt";
		String expected = FileUtils.readFileContentAsString(fileName, PrivateInfoTest.class).trim();

		Assertions.assertEquals(expected, actual);
	}
}