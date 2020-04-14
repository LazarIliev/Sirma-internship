package com.sirma.javacourse.designpatterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for {@link Trade}
 */
public class RunnerStorage {
	private static final Logger logger = LoggerFactory.getLogger(RunnerStorage.class);

	public static void main(String[] args) {
		Storage storage = new Storage();

		String descriptionMouse = "mouse";
		int quantity = 20;
		storage.addProduct(descriptionMouse, quantity);
		storage.addProduct("horse", 5);
		storage.addProduct(descriptionMouse, 10);

		storage.sellProduct(descriptionMouse, 10);
		storage.sellProduct(descriptionMouse, 10);
		storage.sellProduct(descriptionMouse, 10);

		storage.sellProduct("horse", 1);

		logger.info(storage.toString());
	}
}
