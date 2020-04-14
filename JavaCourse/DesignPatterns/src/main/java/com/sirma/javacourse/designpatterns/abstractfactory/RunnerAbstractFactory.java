package com.sirma.javacourse.designpatterns.abstractfactory;

/**
 * Runner class for the abstract factory pattern.
 */
public class RunnerAbstractFactory {
	public static void main(String[] args) {
		AbstractFactory myClassFactory = new MyClassFactory();
		MyClass myClass = myClassFactory.createInstance();
		MyClass myClassByReflection = myClassFactory.createInstanceReflection();
	}
}
