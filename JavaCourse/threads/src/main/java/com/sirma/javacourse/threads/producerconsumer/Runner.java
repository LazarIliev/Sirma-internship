package com.sirma.javacourse.threads.producerconsumer;

/**
 * Demonstrates the work of the producers and consumers.
 */
public class Runner {
	public static void main(String[] args) {
		StoreHouse storeHouse = new StoreHouse(5);
		Producer producerOne = new Producer(storeHouse, 200);
		Thread producer1 = new Thread(producerOne);
		producer1.start();
		Producer producerTwo = new Producer(storeHouse, 1000);
		Thread producer2 = new Thread(producerTwo);
		producer2.start();
		Consumer kiril = new Consumer(storeHouse, 500);
		Thread mincho1 = new Thread(kiril);
		mincho1.setName("Consumer Kiril");
		mincho1.start();
		Consumer pesho = new Consumer(storeHouse, 100);
		Thread pesho1 = new Thread(pesho);
		pesho1.setName("Consumer Pesho");
		pesho1.start();
	}
}
