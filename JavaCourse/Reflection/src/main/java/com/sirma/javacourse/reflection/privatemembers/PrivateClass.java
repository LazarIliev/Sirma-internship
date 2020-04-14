package com.sirma.javacourse.reflection.privatemembers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PrivateClass {
	private static final Logger logger = LoggerFactory.getLogger(PrivateClass.class);

	private int id = 0;
	private int count = 9;
	public int index = 8;

	PrivateClass() {

	}

	private void testPrivateVoidMethod() {
		logger.info("Private method without parameter.");
	}

	private void testPrivateMethodWithParameters(String str) {
		logger.info(str + " private method with parameter.");
	}

	private String testPrivateMethodWithReturnValue(String str) {
		return str;
	}
}
