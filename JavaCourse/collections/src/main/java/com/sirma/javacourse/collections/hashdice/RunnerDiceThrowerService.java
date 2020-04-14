package com.sirma.javacourse.collections.hashdice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for {@link DiceRollService}.
 */
public class RunnerDiceThrowerService {
	private static final Logger logger = LoggerFactory.getLogger(RunnerDiceThrowerService.class);

	public static void main(String[] args) {
		DiceRollService diceRollService = new DiceRollService(5);
		diceRollService.rollDices(20);
		logger.info(diceRollService.toString());
	}
}
