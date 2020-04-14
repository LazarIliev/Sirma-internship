package com.sirma.javacourse.designpatterns.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holds stocks which are available for purchase.
 */
public class AvailableStock {
	private static final Logger logger = LoggerFactory.getLogger(AvailableStock.class);

	private Map<String, Integer> availableStocks;

	/**
	 * Initialize {@link HashMap} for available products.
	 */
	AvailableStock() {
		this.availableStocks = new HashMap<>();
	}

	/**
	 * Add quantity to store.
	 *
	 * @param description product description
	 * @param quantity of the product to add
	 */
	void addQuantity(String description, int quantity) {
		if (availableStocks.containsKey(description)) {
			availableStocks.put(description, availableStocks.get(description) + quantity);
		} else {
			availableStocks.put(description, quantity);
		}
	}

	/**
	 * Remove quantity from available storage.
	 *
	 * @param description product description
	 * @param quantity of the product to remove
	 * @return {@link Boolean} if remove is successful
	 */
	boolean removeQuantity(String description, int quantity) {
		if (availableStocks.containsKey(description)) {
			int availableQuantity = availableStocks.get(description) - quantity;
			if (availableQuantity < 0) {
				logger.info("You can not sell more than what you have! Try again.");
				return false;
			} else {
				availableStocks.put(description, availableQuantity);
				return true;
			}
		} else {
			logger.info("There is no such product!");
			return false;
		}
	}

	/**
	 * Return available products as string.
	 *
	 * @return string of all available products
	 */
	public String toString() {
		Set<String> keys = availableStocks.keySet();
		StringBuilder stb = new StringBuilder();
		stb.append("Stock container:").append(System.lineSeparator());
		for (String key : keys) {
			stb.append("Description:");
			stb.append(key);
			stb.append(" Quantity:");
			stb.append(availableStocks.get(key));
			stb.append(System.lineSeparator());
		}
		return stb.toString().trim();
	}
}
