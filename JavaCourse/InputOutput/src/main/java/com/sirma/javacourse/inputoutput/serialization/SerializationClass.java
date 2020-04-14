package com.sirma.javacourse.inputoutput.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class with two methods for saving and reading an object.
 */
class SerializationClass {
	private static final Logger logger = LoggerFactory.getLogger(SerializationClass.class);

	/**
	 * Saves a custom object to a file using serialization.
	 *
	 * @param path the path to the file that is going to be saved
	 * @param userDefinedObject    the object that is going to be saved
	 */
	void saveObject(String path, UserDefinedObject userDefinedObject) {

		try (FileOutputStream fileOutput = new FileOutputStream(path);
				ObjectOutputStream output = new ObjectOutputStream(fileOutput)) {
				output.writeObject(userDefinedObject);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	/**
	 * Reads an object from the specified path.
	 *
	 * @param path the path from which the object is going to be read
	 * @return the read object
	 */
	UserDefinedObject getObject(String path) {

		try (FileInputStream fileInput = new FileInputStream(path);
				ObjectInputStream input = new ObjectInputStream(fileInput)) {
			return (UserDefinedObject) input.readObject();
		} catch (IOException | ClassNotFoundException e) {
			logger.info(e.getMessage(), e);
			return null;
		}
	}
}
