package com.sirma.javacourse.collections.hashdice;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class DiceRollServiceTest {

	@Test
	void constructor_withNegativeSides_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> { new DiceRollService(2, -1); });
	}

	@Test
	void constructor_withNegativeNumberOfThrows_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> { new DiceRollService(8, 2).rollDices(0); });
	}

	@Test
	void getCombinations_allCombinations_shouldBeBetweenZeroAndSidesOfDice() {
		DiceRollService diceRollService = new DiceRollService(4);
		diceRollService.rollDices(10);

		Set<Integer> combinations = new HashSet<>();

		Map<String, Set<Integer>> statistics = diceRollService.getStatistics();
		for (Map.Entry<String, Set<Integer>> combination : statistics.entrySet()) {
			String[] strings = combination.getKey().split(" ");

			combinations.add(Integer.parseInt(strings[0]));
			combinations.add(Integer.parseInt(strings[1]));
		}

		for (Integer combination : combinations) {
			assertTrue(combination >= 0 && combination <= 4);
		}
	}
}