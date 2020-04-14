package com.sirma.javacourse.designpatterns.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class EmailBuilderTest {
	@Test
	void build_shouldReturnInstanceOfEmail() {
		Email email = Email.builder()
				.fromName("Lazar")
				.toName("Walter")
				.subject("Samo Levski")
				.content("Levski sa mnogo slabi sega :(((")
				.build();
		assertNotNull(email);
	}

	@Test
	void toString_withNormalInput_shouldWork() {
		String from = "Ivan";
		String to = "Pesho";
		String content = "Test content of the mail.";
		String subject = "design patterns";
		String cc = "mail@abv.bg";
		String[] attachments = { "File1", "File2", "File3" };
		Email email = Email.builder()
				.fromName(from)
				.toName(to)
				.subject(subject)
				.content(content)
				.ccEmail(cc)
				.attachments(attachments)
				.build();
		String expected =
				"Mail{from='Ivan', to='Pesho', subject='design patterns', content='Test content of the mail.', "
						+ "cc='mail@abv.bg', attachments=[File1, File2, File3]}";

		assertEquals(expected, email.toString());
	}

	@Test
	void toString_withoutOptionalParameters_shouldWork() {
		String from = "Ivan";
		String to = "Pesho";
		String content = "Test content of the mail.";
		String subject = "design patterns";
		Email email = Email.builder().fromName(from).toName(to).subject(subject).content(content).build();
		String expected =
				"Mail{from='Ivan', to='Pesho', subject='design patterns', content='Test content of the mail.', "
						+ "cc='There is no cc email!', attachments=null}";

		assertEquals(expected, email.toString());
	}
}