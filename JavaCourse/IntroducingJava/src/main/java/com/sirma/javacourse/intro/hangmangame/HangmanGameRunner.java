package com.sirma.javacourse.intro.hangmangame;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is a runner, it is only to initialize HangmanGame class and to invoke his Start method
 */
public class HangmanGameRunner {

	private static final Logger logger = LoggerFactory.getLogger(HangmanGameRunner.class);

	public static void main(String[] args) {
		logger.info("Enter your word to guess: ");

		Scanner input = new Scanner(System.in);
		String wordToGuess = input.nextLine().toUpperCase();
		UserInput userInput = new UserConsoleInput(wordToGuess);

		HangmanGame hangmanGame = new HangmanGame(userInput);
		hangmanGame.start();
	}
}
