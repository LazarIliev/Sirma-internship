package com.sirma.javacourse.threads.counter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runs the counter until user input is provided and then prints the value of the counter.
 */
public class RunnerCounter {
	private static final Logger logger = LoggerFactory.getLogger(RunnerCounter.class);

	public static void main(String[] args) {
		Counter counter1 = new Counter(2);
		Thread counterThread = new Thread(counter1);
		counterThread.start();
		logger.info("Enter char to stop counting");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			char symbol = (char) reader.read();
			counterThread.interrupt();
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
		logger.info("Count value is:" + counter1.getCount());
	}
}
