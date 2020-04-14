package com.sirma.javacourse.inputoutput.filereversing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

/**
 * Class for reversing a file content by line.
 */
class FileReverser {
	private static final Logger logger = LoggerFactory.getLogger(FileReverser.class);

	/**
	 * Util class - no instantiation.
	 */
	private FileReverser() {
	}

	/**
	 * Save reversed file content.
	 * @param fileName a string value of the name of th file.
	 * @param instance a {@link Class} instance of the class in which resources is that file.
	 */
	static void saveFileReversed(String fileName, Class instance) {
		List<String> fileContent = FileUtils.readFile(fileName, instance);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileUtils.getFileFromResources(fileName, instance)))) {
			for (int i = fileContent.size() - 1; i >= 0; i--) {
				if (i > 0) {
					writer.write(fileContent.get(i) + System.lineSeparator());

				} else {
					writer.write(fileContent.get(i));
				}
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}
}
