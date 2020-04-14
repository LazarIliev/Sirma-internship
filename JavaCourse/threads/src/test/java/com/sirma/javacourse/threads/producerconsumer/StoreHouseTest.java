package com.sirma.javacourse.threads.producerconsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class StoreHouseTest {

	@Test
	void put_withNormalData_shouldWork() {
		StoreHouse storeHouse = new StoreHouse(5);

		storeHouse.put(1);
		storeHouse.put(2);
		storeHouse.put(3);
		storeHouse.put(4);
		storeHouse.get();
		storeHouse.put(5);

		assertEquals(4, storeHouse.getLeftSize());
	}

	@Test
	void get_withNormalData_shouldWork() {
		StoreHouse storeHouse = new StoreHouse(5);

		storeHouse.put(1);
		storeHouse.put(2);
		storeHouse.put(3);
		storeHouse.put(4);
		storeHouse.get();
		storeHouse.get();
		storeHouse.get();
		storeHouse.get();
		storeHouse.put(5);
		storeHouse.get();

		assertEquals(0, storeHouse.getLeftSize());
	}
}