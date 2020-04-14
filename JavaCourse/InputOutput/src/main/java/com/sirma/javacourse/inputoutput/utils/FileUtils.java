package com.sirma.javacourse.inputoutput.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Util class for file operations
 */
public class FileUtils {
	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

	/**
	 * @param fileName name of the file.
	 * @param instance {@link Class} instance of the class.
	 * @return file from the resources of the {@link Class}.
	 */
	public static File getFileFromResources(String fileName, Class instance) {
		return new File(instance.getResource(fileName).getFile());
	}

	/**
	 * Reads the file from the specified path.
	 *
	 * @param fileName a string value of the name of th file.
	 * @param instance a {@link Class} instance of the class in which resources is that file.
	 * @return a {@link List<String>} containing all lines of the file.
	 */
	public static List<String> readFile(String fileName, Class instance) {
		String line;
		List<String> textLines = new ArrayList<>();
		File file = getFileFromResources(fileName, instance);
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine()) != null) {
				textLines.add(line);
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
		return textLines;
	}

	/**
	 * Read a file by file name in {@link Class} resources.
	 *
	 * @param fileName a string name of the file.
	 * @param instance a {@link Class} instance of class in which resources's folder is that file.
	 * @return a string value of the file.
	 */
	public static String readFileContentAsString(String fileName, Class instance) {
		String line;
		StringBuilder textLines = new StringBuilder();
		File file = getFileFromResources(fileName, instance);
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			while ((line = reader.readLine()) != null) {
				textLines.append(line).append(System.lineSeparator());
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
		return textLines.toString();
	}
}
