package com.sirma.javacourse.collections.exceptionmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner Class for ExceptionsMessageManager.
 */
public class RunnerExceptionsManager {
	private static final Logger logger = LoggerFactory.getLogger(RunnerExceptionsManager.class);

	public static void main(String[] args) {

		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.DebitCart,
				ExceptionMessages.PersonalID, ExceptionMessages.PostalCode);
		manager.addExceptionMessage(ExceptionMessages.DebitCart.getMessage());
		manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());
		manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
		logger.info(manager.getMessage());
		logger.info(String.valueOf(ExceptionsMessageManager.getMessages(manager.getMessage())));
	}
}
