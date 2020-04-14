package com.sirma.javacourse.chatclient.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private static final String NICKNAME_REG_EX = "[\\w\\d-]+";
	private static final String WHITESPACES_REG_EX = "[\\s]*";
	private static final Pattern NICKNAME_PATTERN = Pattern.compile(NICKNAME_REG_EX,
			Pattern.CASE_INSENSITIVE);
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile(WHITESPACES_REG_EX,
			Pattern.CASE_INSENSITIVE);

	public static final int MAX_NICKNAME_LENGTH = 15;

	/**
	 * Protects from instantiation.
	 */
	private Validator() {
	}

	/**
	 * Checks if given nickname is valid. Valid nickname can consist of - letters, numbers, dash,
	 * underscore.
	 *
	 * @param nickname the nickname to be checked if its valid
	 * @return true if the given nickname is valid, otherwise false
	 */
	public static boolean isValidNickname(String nickname) {
		Matcher matcher = NICKNAME_PATTERN.matcher(nickname);
		return matcher.matches();
	}

	/**
	 * Checks if given chat message contains whitespaces.
	 *
	 * @param message the message to be checked if it is empty
	 * @return true if the give message contains whitespaces, otherwise false
	 */
	public static boolean isWhitespaceMessage(String message) {
		Matcher matcher = WHITESPACE_PATTERN.matcher(message);
		return matcher.matches();
	}
}
