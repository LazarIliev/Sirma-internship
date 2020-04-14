package com.sirma.javacourse.reflection.ibanvalidator;

import java.util.regex.Pattern;

/**
 * Validate if IBAN is correct and if is, replace his symbols with asterisks except last 4.
 */
class IBANValidator {

	/**
	 * Util class - no instantiation.
	 */
	IBANValidator() {
	}

	private static final Pattern PATTERN_IBAN = Pattern.compile("BG[0-9]{2} [a-zA-Z]{4} [0-9]{4} [0-9]{4} [0-9]{4} ");

	static String validateIBANS(String emails) {
		return PATTERN_IBAN.matcher(emails).replaceAll("****");
	}
}
