package com.sirma.javacourse.designpatterns.abstractfactory;

import com.sirma.javacourse.reflection.instance.ReflectionInfoInstanceOfClass;

/**
 * Class for creating an instance from a MyClass by factory method and reflection.
 */
public class MyClassFactory implements AbstractFactory {

	/**
	 * Factory method for making an instance from a MyClass.
	 *
	 * @return instance of the MyClass or null if the className is not correct.
	 */
	@Override
	public MyClass createInstance() {
		return new MyClass();
	}

	/**
	 * Making an instance of MyClass by reflection.
	 *
	 * @return instance of the MyClass or null if the className is not correct.
	 */
	@Override
	public MyClass createInstanceReflection() {
		return (MyClass) ReflectionInfoInstanceOfClass.createFromName(MyClass.class);
	}
}
