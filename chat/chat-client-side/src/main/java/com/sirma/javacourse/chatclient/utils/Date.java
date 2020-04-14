package com.sirma.javacourse.chatclient.utils;

import java.text.SimpleDateFormat;

public final class Date {
	public static final String SIMPLE_TIME_DATE_FORMAT = "hh:mm:ss";

	/**
	 * Protects from instantiation.
	 */
	private Date() {
	}

	/**
	 * Returns the current date in given format. The date format can be taken from this class in the
	 * static constants.
	 *
	 * @param dateFormat the format of the date
	 * @return the formatted current date
	 */
	public static String getCurrentDate(String dateFormat) {
		java.util.Date date = new java.util.Date();
		return new SimpleDateFormat(dateFormat).format(date);
	}
}
