package com.sirma.javacourse.designpatterns.mail;

/**
 * Runner class for building a Mail.
 */
public class RunnerEmailBuilder {
	public static void main(String[] args) {
		String from = "Ivan";
		String to = "Pesho";
		String content = "I'm trying to use Fluent Interface method approach for building a Mail.";
		String subject = "design patterns";
		String cc = "mail@abv.bg";
		String[] attachments = { "File1", "File2", "File3" };

		Email email = Email.builder().fromName(from).toName(to).subject(subject).content(content).build();
	}
}
