package com.sirma.javacourse.designpatterns.observer;

/**
 * Trade observer for managing {@link AvailableStock} and {@link SoldStock}.
 */
public class Trade implements Observer {
	private AvailableStock availableStock;
	private SoldStock soldStock;

	/**
	 * Initialize {@link AvailableStock} and {@link SoldStock}.
	 */
	Trade() {
		this.availableStock = new AvailableStock();
		this.soldStock = new SoldStock();
	}

	/**
	 * Update the right storage container.
	 *
	 * @param isProductForAddOrSell boolean to determine if product is for add or sell
	 * @param description of the product
	 * @param quantity of the product
	 */
	@Override
	public void update(String description, int quantity, boolean isProductForAddOrSell) {
		if (isProductForAddOrSell) {
			availableStock.addQuantity(description, quantity);
		} else {
			if (availableStock.removeQuantity(description, quantity)) {
				soldStock.addQuantity(description, quantity);
			}
		}
	}

	/**
	 * Return all available and sold products.
	 *
	 * @return string value of all products sold and available
	 */
	public String toString() {
		return availableStock.toString() + System.lineSeparator() + soldStock.toString();
	}
}
