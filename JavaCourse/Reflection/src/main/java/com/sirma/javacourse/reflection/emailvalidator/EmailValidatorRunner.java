package com.sirma.javacourse.reflection.emailvalidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Check if email address is valid or not.
 */
public class EmailValidatorRunner {
	private static final Logger logger = LoggerFactory.getLogger(EmailValidatorRunner.class);

	public static void main(String[] args) {
		String email = "H1ello@sirma999.com";

		if (EmailValidator.isEmailValid(email)){
			logger.info(email + " is valid one!");
		}else {
			logger.info(email + " is not valid one!");
		}
	}
}
