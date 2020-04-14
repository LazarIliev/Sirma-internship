package com.sirma.javacourse.inputoutput.filereversing;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

class FileReverserTest {

	@Test
	void saveFileReversed_withCorrectData_shouldWork() {
		String fileName = "/reversingFile.txt";
		List<String> fileLines = (FileUtils.readFile(fileName, FileReverserTest.class));

		Collections.reverse(fileLines);
		String expected = fileLines.toString();
		FileReverser.saveFileReversed(fileName, FileReverserTest.class);
		String actual = FileUtils.readFile(fileName, FileReverserTest.class).toString();

		Assertions.assertEquals(expected, actual);
	}
}