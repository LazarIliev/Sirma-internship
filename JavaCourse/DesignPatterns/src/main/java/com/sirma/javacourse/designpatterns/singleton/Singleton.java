package com.sirma.javacourse.designpatterns.singleton;

/**
 * Class is designed to use Singleton Pattern.
 */
class Singleton {
	private static Singleton object;

	/**
	 * Constructor should only be accessible from within the class.
	 */
	private Singleton() {
	}

	/**
	 * Gets an instance of the class. Can only get one instance.
	 *
	 * @return an instance of the class.
	 */
	static Singleton getInstance() {
		if (object == null) {
			object = new Singleton();
		}
		return object;
	}
}
