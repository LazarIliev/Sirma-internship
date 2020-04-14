package com.sirma.javacourse.designpatterns.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Holds stocks which are unavailable for purchase. Cannot be instantiated.
 */
public class SoldStock {
	private Map<String, Integer> unavailableStocks ;

	/**
	 * Initialize {@link HashMap} for sold products.
	 */
	SoldStock() {
		this.unavailableStocks = new HashMap<>();
	}

	/**
	 * Add product to sold products.
	 *
	 * @param description of the product
	 * @param quantity of the product
	 */
	void addQuantity(String description, int quantity) {
		if (unavailableStocks.containsKey(description)) {
			unavailableStocks.put(description, unavailableStocks.get(description) + quantity);
		} else {
			unavailableStocks.put(description, quantity);
		}
	}

	/**
	 * Return sold products as string.
	 * @return string of all sold products
	 */
	public String toString() {
		Set<String> keys = unavailableStocks.keySet();
		StringBuilder stb = new StringBuilder();
		stb.append("Sold container:").append(System.lineSeparator());
		for (String key : keys) {
			stb.append("Description:");
			stb.append(key);
			stb.append(" Quantity:");
			stb.append(unavailableStocks.get(key));
			stb.append(System.lineSeparator());
		}
		return stb.toString().trim();
	}
}
