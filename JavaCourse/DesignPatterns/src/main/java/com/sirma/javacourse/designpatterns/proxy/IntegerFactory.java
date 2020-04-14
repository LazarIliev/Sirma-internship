package com.sirma.javacourse.designpatterns.proxy;

/**
 * Factory for creating integers.
 */
class IntegerFactory {
	/**
	 * Protects from instantiation.
	 */
	private IntegerFactory() {

	}

	/**
	 * Creates and returns an instance of {@link IntegerProxy}.
	 *
	 * @return an instance of integer proxy
	 */
	static Number createInstance() {
		return new IntegerProxy();
	}
}
