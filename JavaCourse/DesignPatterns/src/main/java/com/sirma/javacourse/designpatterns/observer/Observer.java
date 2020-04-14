package com.sirma.javacourse.designpatterns.observer;


/**
 * Specify Observer functions.
 */
public interface Observer {

	/**
	 * Update the right storage container.
	 *
	 * @param isProductForAddOrSell boolean to determine if product is for add or sell
	 * @param description of the product
	 * @param quantity of the product
	 */
	void update(String description, int quantity, boolean isProductForAddOrSell);
}
