package com.sirma.javacourse.inputoutput.consoletotxt;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


import com.sirma.javacourse.inputoutput.utils.FileUtils;

/**
 * Class for writing an input {@link InputStream} to txt file.
 */
 class ConsoleToTxt {
	/**
	 * Util class - no instantiation.
	 */
	private ConsoleToTxt() {
	}

	/**
	 * Gets data from the input {@link InputStream} and writes it to a file. Can be used with
	 * System.in for console input or with any other {@link InputStream}.
	 * Throws IOException if file not found or incorrect {@link InputStream}.
	 *
	 * @param fileName the name of the file to be saved to
	 * @param input    the {@link InputStream} containing the data to be written to the file
	 */

	static void writeToFile(String fileName , InputStream input) throws IOException {
		File file = FileUtils.getFileFromResources(fileName, ConsoleToTxt.class);

		String line = "";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)); Scanner in = new Scanner(input)) {
			while (in.hasNextLine() && !".".equals(line = in.nextLine())) {
				writer.append(line);
				writer.newLine();
			}
		}
	}
}
