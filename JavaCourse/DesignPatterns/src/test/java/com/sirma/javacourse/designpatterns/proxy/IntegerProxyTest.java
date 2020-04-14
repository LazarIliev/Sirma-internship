package com.sirma.javacourse.designpatterns.proxy;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class IntegerProxyTest {

	@Test
	void constructor_throughIntegerFactoryMethodCreateInstance_shouldWork() {
		Number number = IntegerFactory.createInstance();

		assertTrue(number instanceof IntegerProxy);
	}
}