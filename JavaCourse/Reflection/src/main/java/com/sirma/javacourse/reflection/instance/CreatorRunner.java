package com.sirma.javacourse.reflection.instance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class with static mehtods for creating an instance from a string name of that instance, printing object's interfaces
 * and printing out the parent class of the instance.
 */
public class CreatorRunner {
	private static final Logger logger = LoggerFactory.getLogger(CreatorRunner.class);

	public static void main(String[] args) {
		String objectName = ClassForInstance.class.getName();
		Object obj = ReflectionInfoInstanceOfClass.createFromName(ClassForInstance.class);

		String objInterfaces = ReflectionInfoInstanceOfClass.listInterfaces(obj);
		logger.info(objInterfaces);

		String objParentClass = ReflectionInfoInstanceOfClass.getParent(obj);
		logger.info(objParentClass);
	}
}
