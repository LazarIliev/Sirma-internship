package com.sirma.javacourse.reflection.instance;

/**
 * Class for making an instance of another class by his name, listing his interfaces and getting his parent class.
 */
public class ReflectionInfoInstanceOfClass {

	/**
	 * Util class - no instantiation.
	 */
	ReflectionInfoInstanceOfClass() {
	}

	/**
	 * List interfaces.
	 *
	 * @param object the object that interfaces will be listed.
	 * @return interfaces.
	 */
	static String listInterfaces(Object object) {
		if (object != null) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Interfaces:").append(System.lineSeparator());
			for (Class<?> interfc : object.getClass().getInterfaces()) {
				stringBuilder.append(interfc.getName()).append(System.lineSeparator());
			}
			return stringBuilder.toString().trim();
		}
		return null;
	}

	/**
	 * extract parent class name.
	 *
	 * @param object the object which will be read from.
	 * @return parent class name as text.
	 */
	static String getParent(Object object) {
		if (object != null) {
			return "Super class:" + object.getClass().getSuperclass().toString();
		}
		return null;
	}

	/**
	 * Create class whit reflection from name.
	 *
	 * @param className the {@link Class} of class that will be created.
	 * @return created object. Or null if operation is not successful.
	 */
	public static Object createFromName(Class<?> className) {
		if (className == null) {
			return null;
		}
		try {
			return className.getDeclaredConstructor().newInstance();
		} catch (ReflectiveOperationException e) {
			return null;
		}
	}
}
