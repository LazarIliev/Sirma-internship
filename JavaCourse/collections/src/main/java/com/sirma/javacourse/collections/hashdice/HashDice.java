package com.sirma.javacourse.collections.hashdice;

import java.util.Random;

/**
 * This class implements a dice with specified number of sides for rolling.
 */
class HashDice {
	private static final Random RANDOM_GENERATOR = new Random();
	private int sides;

	/**
	 * This constructs a dice with a specified sides.
	 *
	 * @param sides number of sides of the dice
	 */
	HashDice(int sides) {
		this.sides = sides;
	}

	/**
	 * The method is rolling this dice and with a {@code Random} class instance is generating a random result
	 * in the bounds of the dice from 1 to the number of the sides of that dice inclusive, for the roll.
	 *
	 * @return the result of the roll.
	 */
	int rollDice() {
		return RANDOM_GENERATOR.nextInt(sides + 1);
	}
}
