package com.sirma.javacourse.inputoutput.serialization;

import java.io.Serializable;

/**
 * Class for serialization.
 */
class UserDefinedObject implements Serializable {

	private String name;

	/**
	 * Setting the name field of the class.
	 *
	 * @param name value to be set to the name field
	 */
	UserDefinedObject(String name) {
		this.name = name;
	}

	/**
	 * Getter method for name.
	 *
	 * @return the name
	 */
	String getName() {
		return name;
	}
}
