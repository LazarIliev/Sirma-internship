package com.sirma.javacourse.inputoutput.consoletotxt;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for String input writing to txt file.
 */
public class ConsoleToTxtRunner {
	private static final Logger logger = LoggerFactory.getLogger(ConsoleToTxtRunner.class);

	public static void main(String[] args) {
		try (InputStream input = System.in) {
			String fileName = "/consoleTo.txt";
			ConsoleToTxt.writeToFile(fileName, input);
		} catch (IOException e){
			logger.info(e.getMessage(), e);
		}
	}
}
