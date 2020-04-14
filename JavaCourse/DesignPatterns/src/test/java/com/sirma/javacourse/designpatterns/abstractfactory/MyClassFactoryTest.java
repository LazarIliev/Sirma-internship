package com.sirma.javacourse.designpatterns.abstractfactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class MyClassFactoryTest {
	private MyClassFactory myClassFactory = new MyClassFactory();

	@Test
	void createInstanceMyClass() {
		MyClass myClass = myClassFactory.createInstance();
		assertNotNull(myClass);
	}

	@Test
	void createInstanceMyClassReflection() {
		MyClass myClass = myClassFactory.createInstanceReflection();
		assertNotNull(myClass);
	}
}