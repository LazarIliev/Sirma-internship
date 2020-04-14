package com.sirma.javacourse.intro.hangmangame;

import java.util.Scanner;

/**
 * This class is to get user inputs through the console.
 */
 class UserConsoleInput implements UserInput {

	private String word;

	/**
	 * This is the constructor class.
	 *
	 * @param word to guess from the user.
	 */
	UserConsoleInput(String word) {
		this.word = word;
	}

	/**
	 * Method for getting the set word to guess.
	 *
	 * @return string value of the user's input for the word to guess.
	 */
	@Override public String getInput() {
		return word;
	}

	/**
	 * Ask the user to write an string through the console.
	 *
	 * @return char value from the user to check.
	 */
	@Override public char getCharInput() {
		Scanner input = new Scanner(System.in);

		return input.nextLine().toUpperCase().charAt(0);
	}
}
