package com.sirma.javacourse.reflection.readinginfoaboutclass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Class for getting information about random class's methods info and fields info.
 */
class ClassInfo {
	
	/**
	* Util class - no instantiation.
	*/
	ClassInfo() {
	}

	/**
	 * Using reflection to get the methods of the random class.
	 *
	 * @param randomObject The random object which methods we are going to get
	 * @return string of methods from the class
	 */
	static String getClassMethodsSignature(Object randomObject) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Method method : randomObject.getClass().getDeclaredMethods()) {
			stringBuilder.append(method.toString()).append(System.lineSeparator());
		}
		return stringBuilder.toString();
	}

	/**
	 * Using reflection to get the fields of the random class.
	 * Throws IllegalAccessException if the field is not accessible.
	 *
	 * @param randomObject The random object which fields we are going to get
	 * @return string of fields from the class
	 */
	static String getClassFields(Object randomObject) throws IllegalAccessException {
		StringBuilder stringBuilder = new StringBuilder();
		for (Field field : randomObject.getClass().getDeclaredFields()) {
			if (Modifier.isPrivate(field.getModifiers())) {
				field.setAccessible(true);
			}
			stringBuilder.append(field.toString()).append(" : ").append(field.get(randomObject))
					.append(System.lineSeparator());
		}
		return stringBuilder.toString();
	}
}
