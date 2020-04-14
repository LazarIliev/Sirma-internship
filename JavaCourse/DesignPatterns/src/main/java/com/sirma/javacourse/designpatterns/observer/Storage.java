package com.sirma.javacourse.designpatterns.observer;

/**
 * Storage class for adding and selling products.
 */
public class Storage {

	private Observer observer;

	/**
	 * Initialize observer.
	 */
	Storage() {
		this.observer = new Trade();
	}

	/**
	 * Return all available and sold products.
	 *
	 * @return string value of all products sold and available
	 */
	public String toString() {
		return observer.toString();
	}

	/**
	 * Add product to the storage.
	 *
	 * @param description of the product
	 * @param quantity of the product
	 */
	void addProduct(String description, int quantity) {
		notifyObserver(description, quantity, true);
	}

	/**
	 * Sell product if is possible.
	 *
	 * @param description of the product for sell
	 * @param quantity of the product for sell
	 */
	void sellProduct(String description, int quantity) {
		notifyObserver(description, quantity, false);
	}

	/**
	 * Notify observer.
	 *
	 * @param isProductForAddOrSell boolean to determine if product is for add or sell
	 * @param description of the product
	 * @param quantity of the product
	 */
	private void notifyObserver(String description, int quantity, boolean isProductForAddOrSell) {
		observer.update(description, quantity, isProductForAddOrSell);
	}
}
