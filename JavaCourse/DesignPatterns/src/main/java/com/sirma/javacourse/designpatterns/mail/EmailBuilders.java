package com.sirma.javacourse.designpatterns.mail;

/**
 * Interface for the {@link com.sirma.javacourse.designpatterns.mail.Email.EmailBuilder}.
 */
public interface EmailBuilders {
	/**
	 * Mandatory interface for setting a sender name.
	 */
	interface FromName {
		ToName fromName(String fromName);
	}

	/**
	 * Mandatory interface for setting a receiver name.
	 */
	interface ToName {
		Subject toName(String toName);
	}

	/**
	 * Mandatory interface for setting a subject of the email.
	 */
	interface Subject {
		Content subject(String subject);
	}

	/**
	 * Mandatory interface for setting a content of the email.
	 */
	interface Content {
		Build content(String content);
	}

	/**
	 * Build interface for generating an email.
	 */
	interface Build {
		/**
		 * Optional method for setting a cc of the email.
		 * @param ccEmail to be send the email
		 */
		Build ccEmail(String ccEmail);

		/**
		 * Optional method for setting the attachments of the email.
		 * @param attachments to be send the email
		 */
		Build attachments(String[] attachments);

		/**
		 * Build method for generating the email.
		 * @return generated email
		 */
		Email build();
	}
}