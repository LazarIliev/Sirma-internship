package com.sirma.javacourse.reflection.readinginfoaboutclass;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ClassInfoTest {

	@Test
	void getClassFields_withCorrectData_shouldWork() throws IllegalAccessException {
		RandomClass randomClass = new RandomClass();
		String actualFieldsInfo = ClassInfo.getClassFields(randomClass);
		String fileName = "/classInfo.txt";
		String expected = FileUtils.readFileContentAsString(fileName, ClassInfoTest.class);

		Assertions.assertEquals(expected, actualFieldsInfo);
	}
}