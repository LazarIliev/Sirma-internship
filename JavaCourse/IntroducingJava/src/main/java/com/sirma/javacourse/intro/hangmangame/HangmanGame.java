package com.sirma.javacourse.intro.hangmangame;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HangmanGame class with one method to start the game.
 */
class HangmanGame {
	private static final Logger logger = LoggerFactory.getLogger(HangmanGame.class);

	private int attempts;
	private int length;
	private char[] wordToGuessChars;
	private char[] censor;
	private boolean isHangmanGameFinished;
	private UserInput userInput;
	private Set<String> previousGuesses;

	/**
	 * This method is the constructor of the class.
	 * By his initialization is setting starting values for the game.
	 *
	 * @param userInput is the class for the user input.
	 */
	HangmanGame(UserInput userInput) {
		this.userInput = userInput;
		this.previousGuesses = new HashSet<>();
		this.attempts = 0;
		this.length = userInput.getInput().length();
		this.wordToGuessChars = userInput.getInput().toCharArray(); //creates char array of string
		this.isHangmanGameFinished = false;
		this.censor = new char[length];

		setCensorWord();
		logger.info(String.format("You have maximum attempts: %d .", length * 2));
		logger.info("Your secret word is: ");
		printCensorWord();
	}

	/**
	 * This method is to check at the end whether the user has known the word.
	 *
	 * @return the guessed word from the user.
	 */
	String getWordToGuessCensor() {
		return String.valueOf(censor);
	}

	/**
	 * User guesses one letter at a time until the entire word is guessed or
	 * reached out the limit of double times length of the word to guess. Program will inform the user if the guess is in the word,
	 * and show the progress of the word after each guess.
	 * If the guessed letter is in the word, program will print out the # of times the letter is in the word.
	 * Program will store and print out # of guesses (attempts) needed to guess the word at the end of the program.
	 * If user tries to duplicate a previous guess, program will inform user of that and show previous guesses by user.
	 */
	void start() {
		while (!isHangmanGameFinished) {
			logger.info("Type your guess: ");
			char currentGuessChar = userInput.getCharInput();
			attempts++;

			if (isCharAlreadyGuessed(currentGuessChar)) {
				logger.info("You already guessed this letter! Guess again. Your previous guesses were: ");
				logger.info(String.valueOf(previousGuesses));

				isHangmanGameFinished = isAttemptsEqualToMaxAttempts();
				continue;
			}

			previousGuesses.add(String.valueOf(currentGuessChar));

			guessCharCheckTimes(currentGuessChar);

			printCensorWord();

			isHangmanGameFinished =
					isAttemptsEqualToMaxAttempts() || String.valueOf(censor).equals(String.valueOf(wordToGuessChars));
		}
		gameResult();
	}

	private boolean isCharAlreadyGuessed(char currentGuessChar) {
		return previousGuesses.contains(String.valueOf(currentGuessChar));
	}

	private void guessCharCheckTimes(char currentGuessChar) {
		int times = 0; //number of times a letter is in the word
		times = checkChar(times, currentGuessChar);
		if (times > 0) {
			logger.info("The letter " + currentGuessChar + " is in the secret word! There are " + times + " "
					+ currentGuessChar + " 's in the word. Revealing the letter(s): ");
		} else {
			logger.info(
					String.format("Sorry, the letter %c is not in the word. Your secret word:  ", currentGuessChar));
		}
	}

	private void gameResult() {
		if (isAttemptsEqualToMaxAttempts()) {
			logger.info(String.format("Sorry, but you have exceeded the maximum number of attempts(%d) at this time. ",
					attempts));
		} else {
			logger.info("You guessed the entire word " + String.valueOf(wordToGuessChars).toUpperCase()
					+ " correctly! It took you " + attempts + " attempts!");
		}
	}

	/**
	 * Property for validation check if the user exceed the max allowed attempts.
	 */
	private boolean isAttemptsEqualToMaxAttempts() {
		return attempts == length * 2;
	}

	private void printCensorWord() {
		//prints the censored secret word
		for (int a = 0; a < length; a++) {
			logger.info(String.valueOf(censor[a]));
		}
	}

	private int checkChar(int times, char currentGuessChar) {
		for (int index = 0; index < length; index++) {
			if (wordToGuessChars[index] == currentGuessChar) {
				censor[index] = currentGuessChar;  //replaces * with guessed letter in caps
				times++;
			}
		}
		return times;
	}

	private void setCensorWord() {
		for (int index = 0; index < length; index++) {
			censor[index] = '*';
		}
	}
}
