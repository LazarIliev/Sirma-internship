package com.sirma.javacourse.inputoutput.consoletotxt;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

class ConsoleToTxtTest {

	@Test
	void writeToFile_withCorrectData_shouldWork() throws IOException {
		StringBuilder sb = new StringBuilder();
		String fileName = "/consoleTo.txt";
		String expected = FileUtils.readFileContentAsString(fileName, ConsoleToTxt.class);

		try (InputStream input = new ByteArrayInputStream(expected.getBytes())) {
			ConsoleToTxt.writeToFile(fileName, input);
		}

		File file = FileUtils.getFileFromResources(fileName, ConsoleToTxtTest.class);
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				sb.append(sc.nextLine()).append(System.lineSeparator());
			}
		}
		Assertions.assertEquals(expected, sb.toString());
	}
}