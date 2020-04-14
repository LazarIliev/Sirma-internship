package com.sirma.javacourse.objects.supermarket;

import java.math.BigDecimal;
import java.util.HashMap;

public class Supermarket {
	private HashMap<Integer, Employee> employees;
	private HashMap<Integer, Stock> products;
	private HashMap<Integer, Client> clients;
	private String name;
	private BigDecimal profit;

	/**
	 * Creates a new supermarket.
	 * 
	 * @param name - the supermarket's name
	 */
	public Supermarket(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("The supermarket's name cannot be empty");
		}

		this.name = name;
		this.employees = new HashMap<>();
		this.clients = new HashMap<>();
		this.products = new HashMap<>();
		this.profit = new BigDecimal("0");
	}

	/**
	 * @return - the supermarket's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return - the supermarket's profit
	 */
	public BigDecimal getProfit() {
		return profit;
	}

	/**
	 * Method to add an employee into the supermarket.
	 */
	public void addEmployee(Employee employee) {
		employees.put(employee.getEmployeeID(), employee);
	}

	/**
	 * Method to add a product into the supermarket.
	 */
	public void addProduct(Stock product) {
		products.put(product.getProductID(), product);
	}

	/**
	 * Method to add client into the supermarket.
	 */
	public void addClient(Client client) {
		clients.put(client.getClientID(), client);
	}

	/**
	 * Method for buying a product from a client.
	 */
	public void buy(int clientID, int productID) {
		if (!products.containsKey(productID)) {
			throw new IllegalArgumentException("No such product with ID : " + productID);
		}
		if (!clients.containsKey(clientID)) {
			throw new IllegalArgumentException("No such client with ID : " + clientID);
		}

		Stock product = products.get(productID);
		product.setAmount(product.getAmount() - 1);

		BigDecimal price = product.getPrice();
		profit.add(price);
	}
}
