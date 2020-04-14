package com.sirma.javacourse.collections.exceptionmanager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class ExceptionsMessageManagerTest {

	@Test
	void testAddExceptionMessageNotExistingMessage() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.DebitCart);

		assertThrows(IllegalArgumentException.class, () -> {manager.addExceptionMessage("Not existing message");});
	}

	@Test
	void testAddExceptionMessageCodeNotExistingMessage() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.PostalCode);

		assertThrows(IllegalArgumentException.class,
				() -> { manager.addExceptionMessageUsingCode("Not existing message code");});
	}

	@Test
	void testWithEmptyManagerCode() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager();

		assertThrows(IllegalArgumentException.class,
				() -> { manager.addExceptionMessageUsingCode("Not existing message code");});
	}

	@Test
	void testWithEmptyManager() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager();

		assertThrows(IllegalArgumentException.class, () -> { manager.addExceptionMessage("Not existing message");});
	}

	@Test
	void testAddExceptionWithOneElement() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.PostalCode);

		manager.addExceptionMessage(ExceptionMessages.PostalCode.getMessage());
		String actual = manager.getMessage();
		String expected = "Invalid postal code";

		assertEquals(expected, actual);
	}

	@Test
	void testAddExceptionWithThreeElements() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.PostalCode,
				ExceptionMessages.DebitCart, ExceptionMessages.PersonalID);

		manager.addExceptionMessage(ExceptionMessages.PostalCode.getMessage());
		manager.addExceptionMessage(ExceptionMessages.DebitCart.getMessage());
		manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());
		String actual = manager.getMessage();
		String expected = "Invalid postal code|Invalid debit cart ID|Invalid personal ID";

		assertEquals(expected, actual);
	}

	@Test
	void testAddExceptionCodeWithThreeElements() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.PostalCode,
				ExceptionMessages.DebitCart, ExceptionMessages.PersonalID);

		manager.addExceptionMessageUsingCode(ExceptionMessages.PostalCode.name());
		manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
		manager.addExceptionMessageUsingCode(ExceptionMessages.PersonalID.name());
		String actual = manager.getMessage();
		String expected = "Invalid postal code|Invalid debit cart ID|Invalid personal ID";

		assertEquals(expected, actual);
	}

	@Test
	void testAddExceptionCodeWithOneElement() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.DebitCart);

		manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
		String actual = manager.getMessage();
		String expected = "Invalid debit cart ID";

		assertEquals(expected, actual);
	}

	@Test
	void testAddExceptions() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.DebitCart,
				ExceptionMessages.PersonalID, ExceptionMessages.PostalCode);

		manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());
		manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
		manager.addExceptionMessage(ExceptionMessages.PostalCode.getMessage());
		String actual = manager.getMessage();
		String expected = "Invalid personal ID|Invalid debit cart ID|Invalid postal code";

		assertEquals(expected, actual);
	}

	@Test
	void testGetMessagesWithThreeElements() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.DebitCart,
				ExceptionMessages.PersonalID, ExceptionMessages.PostalCode);

		manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());
		manager.addExceptionMessageUsingCode(ExceptionMessages.DebitCart.name());
		manager.addExceptionMessage(ExceptionMessages.PostalCode.getMessage());

		Collection<String> actual = ExceptionsMessageManager.getMessages(manager.getMessage());
		Collection<String> expected = new ArrayList<>();
		expected.add("Invalid personal ID");
		expected.add("Invalid debit cart ID");
		expected.add("Invalid postal code");

		assertEquals(expected, actual);
	}

	@Test
	void testGetMessagesWithOneElement() {
		ExceptionsMessageManager manager = new ExceptionsMessageManager(ExceptionMessages.DebitCart,
				ExceptionMessages.PersonalID, ExceptionMessages.PostalCode);

		manager.addExceptionMessage(ExceptionMessages.PersonalID.getMessage());

		Collection<String> actual = ExceptionsMessageManager.getMessages(manager.getMessage());
		Collection<String> expected = new ArrayList<>();
		expected.add("Invalid personal ID");

		assertEquals(expected, actual);
	}
}