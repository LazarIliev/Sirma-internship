package com.sirma.javacourse.intro.hangmangame;

public class UserTestInput implements UserInput {

	private String word;
	private int counter;
	private char[] guessInput;

	/**
	 * This is the constructor class.
	 *
	 * @param word       string value of the word to guess
	 * @param guessInput char array of the test input for
	 */
	public UserTestInput(String word, char[] guessInput) {
		this.word = word;
		this.counter = 0;
		this.guessInput = guessInput;
	}

	/**
	 * Method for getting the set word to guess.
	 *
	 * @return string value of the user's input for the word to guess.
	 */
	@Override
	public String getInput() {
		return word;
	}

	/**
	 * Get on every invoke char from the guessInput at counter position.
	 *
	 * @return char value to check.
	 */
	@Override
	public char getCharInput() {
		if (counter == word.length()) {
			counter = 0;
		}
		return guessInput[counter++];
	}
}
