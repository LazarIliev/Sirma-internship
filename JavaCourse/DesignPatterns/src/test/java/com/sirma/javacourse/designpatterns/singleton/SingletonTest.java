package com.sirma.javacourse.designpatterns.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SingletonTest {

	@Test
	void getInstance_tryingToMakeTwoInstances_shouldReturnOneInstanceForBothVariables() {
		Singleton firstInstance = Singleton.getInstance();
		Singleton secondInstance = Singleton.getInstance();

		Assertions.assertEquals(firstInstance, secondInstance);
	}
}