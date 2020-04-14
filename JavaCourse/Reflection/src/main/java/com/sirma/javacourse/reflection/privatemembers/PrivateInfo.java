package com.sirma.javacourse.reflection.privatemembers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for getting a private fields and methods about another class.
 */
class PrivateInfo {
	private static final Logger logger = LoggerFactory.getLogger(PrivateInfo.class);

	/**
	 * Util class - no instantiation.
	 */
	PrivateInfo() {
	}

	/**
	 * Read private fields names and values and save it as string.
	 *
	 * @param object to which only private fields will be taken.
	 * @return private fields signatures of object like a string.
	 */
	static String getPrivateFields(Object object) {
		if (object == null) {
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Private fields:").append(System.lineSeparator());
		for (Field field : object.getClass().getDeclaredFields()) {
			if (Modifier.isPrivate(field.getModifiers())) {
				field.setAccessible(true);
				stringBuilder.append(field.getName()).append(":");
				try {
					stringBuilder.append(field.get(object)).append(System.lineSeparator());
				} catch (ReflectiveOperationException e) {
					logger.info(e.getMessage(), e);
				}
			}
		}
		return stringBuilder.toString().trim();
	}

	/**
	 * Invoke private methods.
	 *
	 * @param object on which private methods will be invoked.
	 * @return list of invoked methods and result status.
	 */
	static String invokePrivateMethods(Object object) {
		if (object == null) {
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (Method method : object.getClass().getDeclaredMethods()) {
			if (Modifier.isPrivate(method.getModifiers())) {
				stringBuilder.append("Invoke: ").append(method.getName());
				method.setAccessible(true);
				try {
					if (method.getParameterCount() == 0) {
						method.invoke(object);
					} else {
						method.invoke(object, "string argument");
					}
					stringBuilder.append(" - OK").append(System.lineSeparator());
				} catch (ReflectiveOperationException e) {
					logger.info(e.getMessage(), e);
				}
			}
		}
		return stringBuilder.toString().trim();
	}
}
