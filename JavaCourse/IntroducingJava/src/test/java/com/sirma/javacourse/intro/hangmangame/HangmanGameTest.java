package com.sirma.javacourse.intro.hangmangame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HangmanGameTest {

	private HangmanGame hangmanGame;

	@Test
	void HangmanGame_withCorrectInput_shouldWork() {
		String actualWord = "day";

		UserInput userInput = new UserTestInput(actualWord, new char[] { 'd', 'a', 'y' });

		this.hangmanGame = new HangmanGame(userInput);
		hangmanGame.start();

		String expectedWord = hangmanGame.getWordToGuessCensor();

		Assertions.assertEquals(expectedWord, actualWord);
	}

	@Test
	void HangmanGame_withIncorrectInput_shouldNotWork() {
		String actualWord = "day";
		UserInput userInput = new UserTestInput(actualWord, new char[] { 'd', 'o', 'y' });

		this.hangmanGame = new HangmanGame(userInput);
		hangmanGame.start();

		String expectedWord = hangmanGame.getWordToGuessCensor();

		Assertions.assertNotEquals(expectedWord, actualWord);
	}
}