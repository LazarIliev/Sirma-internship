package com.sirma.javacourse.reflection.emailvalidator;

import java.util.regex.Pattern;

/**
 * An email validator class that checks if an email is valid with regex.
 */
class EmailValidator {
	private static final Pattern PATTERN_EMAIL = Pattern.compile("[a-zA-Z][a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,5}$");

	/**
	 * Util class - no instantiation.
	 */
	EmailValidator() {
	}

	/**
	 * Checking if the input email is valid with regex.
	 *
	 * @param email the email to be checked
	 * @return true if it is valid, false otherwise
	 */
	static boolean isEmailValid(String email) {
		return PATTERN_EMAIL.matcher(email).matches();
	}
}
