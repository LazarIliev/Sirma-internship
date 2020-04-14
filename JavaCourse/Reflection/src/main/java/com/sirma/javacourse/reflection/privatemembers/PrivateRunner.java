package com.sirma.javacourse.reflection.privatemembers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class with static methods to get private fields of other class and invoke his private methods with reflection.
 */
public class PrivateRunner {
	private static final Logger logger = LoggerFactory.getLogger(PrivateRunner.class);

	public static void main(String[] args) {
		PrivateClass privateClass = new PrivateClass();

		String privateFields = PrivateInfo.getPrivateFields(privateClass);
		logger.info(privateFields);

		String privateMethods = PrivateInfo.invokePrivateMethods(privateClass);
		logger.info(privateMethods);
	}
}
