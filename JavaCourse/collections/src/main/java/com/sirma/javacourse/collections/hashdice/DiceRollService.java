package com.sirma.javacourse.collections.hashdice;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * This is a service class for rolling two dices and stores combinations of the dices and their numbers of rolls.
 */
class DiceRollService {
	private Map<String, Set<Integer>> statistics;
	private HashDice firstDice;
	private HashDice secondDice;

	/**
	 * Constructs a dice roll service for the two {@link HashDice} with equal number of sides and initialize them.
	 * Initialize also {@link LinkedHashMap} for the results of the rolls of the dices.
	 *
	 * @param sides integer value of the sides of the dices
	 */
	DiceRollService(int sides) {
		this(sides, sides);
	}

	/**
	 * Constructs a dice roll service for the two {@link HashDice} with different number of sides and initialize them.
	 * Initialize also {@link LinkedHashMap} for the results of the rolls of the dices.
	 *
	 * @param sidesFirst value of the sides of the first dice
	 * @param sidesSecond value of the sides of the second dice
	 */
	DiceRollService(int sidesFirst, int sidesSecond) {
		if (sidesFirst <= 0 || sidesSecond <= 0) {
			throw new IllegalArgumentException("The parameter 'sides' cannot be equal or under to zero");
		}
		this.statistics = new LinkedHashMap<>();
		this.firstDice = new HashDice(sidesFirst);
		this.secondDice = new HashDice(sidesSecond);
	}

	/**
	 * Creating a string from the statistics on every entry set
	 * which represent results for every different combination on which roll occur.
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Entry<String, Set<Integer>> entry : statistics.entrySet()) {
			Set<Integer> rounds = entry.getValue();
			result.append("{").append(entry.getKey()).append("}: ").append(rounds);
			result.append(System.lineSeparator());
		}
		return result.toString();
	}

	/**
	 * Return the {@link LinkedHashMap} with the statistics for both dices.
	 *
	 * @return {@link LinkedHashMap} with the statistics for the both dices
	 */
	Map<String, Set<Integer>> getStatistics() {
		return statistics;
	}

	/**
	 * Generates the dices combinations and rounds when they are roll.
	 * On every roll save the combination.
	 *
	 * @param numberOfRolls number of the times that dices will be roll
	 * @throws IllegalArgumentException if the number of the rolls is negative number or zero
	 */
	void rollDices(int numberOfRolls) {
		if (numberOfRolls <= 0) {
			throw new IllegalArgumentException("The parameter 'numberOfRolls' cannot be equal or under to zero");
		}
		for (int i = 0; i < numberOfRolls; i++) {
			saveCombination(firstDice.rollDice(), secondDice.rollDice(), i);
		}
	}

	/**
	 * Save combinations for the current roll for the first and second dice.
	 *
	 * @param firstDiceRollResult combination
	 * @param secondDiceRollResult combination
	 * @param round of the current roll
	 */
	private void saveCombination(int firstDiceRollResult, int secondDiceRollResult, int round) {
		String combination = firstDiceRollResult + " " + secondDiceRollResult;
		if (statistics.containsKey(combination)) {
			statistics.get(combination).add(round);
		} else {
			Set<Integer> set = new HashSet<>();
			set.add(round);
			statistics.put(combination, set);
		}
	}
}
