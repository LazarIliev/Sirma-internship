package com.sirma.javacourse.objects.supermarket;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SupermarketRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(SupermarketRunner.class);

	public static void main(String[] args) {
		Supermarket market = new Supermarket("My market");

		Employee george = new Guard("George", 23, Departments.Guard);
		Client pesho = new Client("Pesho", 29);
		Stock sweet = new Sweet("Natural sweet", "Sweet for cooking", new BigDecimal("1.99"),
				25);

		market.addClient(pesho);
		market.addEmployee(george);
		market.addProduct(sweet);
		market.buy(pesho.getClientID(), sweet.getProductID());

		logger.info(String.valueOf(george.getEmployeeID()));

		Employee joro = new Cashier("Joro", 30, Departments.Cashier);
		market.addEmployee(joro);
		logger.info(String.valueOf(joro.getEmployeeID()));
	}

}
