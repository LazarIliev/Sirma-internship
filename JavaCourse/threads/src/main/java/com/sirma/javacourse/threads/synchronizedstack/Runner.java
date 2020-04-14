package com.sirma.javacourse.threads.synchronizedstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for the {@link ListOfElements}.
 */
public class Runner {
	private static final Logger logger = LoggerFactory.getLogger(Runner.class);

	public static void main(String[] args) throws InterruptedException {
		ListOfElements listOfElements = new ListOfElements(2);
		listOfElements.add(3);
		listOfElements.add(3);
		listOfElements.add(4);
		listOfElements.remove();

		Thread.sleep(3000);

		logger.info(listOfElements.getAllElements());
	}
}
