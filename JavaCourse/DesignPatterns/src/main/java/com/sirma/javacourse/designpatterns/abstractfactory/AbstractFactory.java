package com.sirma.javacourse.designpatterns.abstractfactory;

/**
 * Abstract factory interface for creating an instance from MyClass by two ways with a factory method and by reflection.
 */
public interface AbstractFactory {
	/**
	 * Factory method for making an instance from a MyClass.
	 *
	 * @return instance of the MyClass or null if the className is not correct.
	 */
	MyClass createInstance();

	/**
	 * Making an instance of MyClass by reflection.
	 *
	 * @return instance of the MyClass or null if the className is not correct.
	 */
	MyClass createInstanceReflection();
}