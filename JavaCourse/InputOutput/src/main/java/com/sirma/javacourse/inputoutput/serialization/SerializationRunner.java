package com.sirma.javacourse.inputoutput.serialization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for serialization of object.
 */
public class SerializationRunner {
	private static final Logger logger = LoggerFactory.getLogger(SerializationRunner.class);

	public static void main(String[] args) {
		String filePath = "InputOutput\\userDefinedObject.usr";
		UserDefinedObject userObject = new UserDefinedObject("Pesho");
		SerializationClass objectManipulator = new SerializationClass();
		objectManipulator.saveObject(filePath, userObject);

		UserDefinedObject userObj = objectManipulator.getObject(filePath);
		logger.info(userObj.getName());
	}
}
