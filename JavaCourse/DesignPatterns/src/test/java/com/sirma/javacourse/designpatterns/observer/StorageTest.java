package com.sirma.javacourse.designpatterns.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

class StorageTest {

	@Test
	void addProduct_withNormalInput_shouldWork() {
		Storage storage = new Storage();
		String fileName = "/buyItem.txt";
		String productDescriptionBread = "bread";
		int quantityBread = 15;
		String expected = FileUtils.readFileContentAsString(fileName, StorageTest.class).trim();

		storage.addProduct(productDescriptionBread, quantityBread);

		assertEquals(expected, storage.toString());
	}

	@Test
	void sellProduct_withNormalInput_shouldWork() {
		Storage storage = new Storage();
		String fileName = "/sellItem.txt";
		String productDescriptionBread = "bread";
		int quantityBread = 10;
		String expected = FileUtils.readFileContentAsString(fileName, StorageTest.class).trim();

		storage.addProduct(productDescriptionBread, quantityBread);
		storage.sellProduct(productDescriptionBread, 5);

		assertEquals(expected, storage.toString());
	}
}