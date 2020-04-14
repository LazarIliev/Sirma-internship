package com.sirma.javacourse.inputoutput.consolereader;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for the ConsoleReader.
 */
public class ConsoleReaderRunner {
	private static final Logger logger = LoggerFactory.getLogger(ConsoleReaderRunner.class);

	public static void main(String[] args) {
		try {
			logger.info("Enter a string:");
			String result = ConsoleReader.readString(System.in);
			logger.info(result);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}
}
