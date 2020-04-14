package com.sirma.javacourse.designpatterns.mail;

import java.util.Arrays;

/**
 * Class for creating a mail by fluent interface approach.
 */
class Email {
	private String from;
	private String to;
	private String subject;
	private String content;
	private String cc;
	private String[] attachments;

	/**
	 * Email can be generated only through the builder.
	 *
	 * @param from name of the sender
	 * @param to name of the receiver
	 * @param subject name of the email
	 * @param content of the email
	 * @param cc of the email
	 * @param attachments of the email
	 */
	private Email(String from, String to, String subject, String content, String cc, String[] attachments) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.content = content;
		this.cc = cc == null ? "There is no cc email!" : cc;
		this.attachments = attachments;
	}

	/**
	 * @return a string value from the content of the mail.
	 */
	@Override
	public String toString() {
		return "Mail{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", subject='" + subject + '\'' + ", content='"
				+ content + '\'' + ", cc='" + cc + '\'' + ", attachments=" + Arrays.toString(attachments) + '}';
	}

	/**
	 * Starting point of the chain of methods for building an email.
	 *
	 * @return the builder
	 */
	public static EmailBuilders.FromName builder() {
		return new EmailBuilder();
	}

	/**
	 * Static class for building an email.
	 */
	public static class EmailBuilder
			implements EmailBuilders.FromName, EmailBuilders.ToName, EmailBuilders.Subject, EmailBuilders.Content,
					   EmailBuilders.Build {
		private String from;
		private String to;
		private String subject;
		private String content;
		private String cc;
		private String[] attachments;

		private EmailBuilder() {
		}

		/**
		 * Setting the sender name.
		 *
		 * @param fromName name of the sender
		 * @return the builder
		 */
		@Override
		public EmailBuilders.ToName fromName(String fromName) {
			this.from = fromName;
			return this;
		}

		/**
		 * Setting the receiver name.
		 *
		 * @param toName name of the receiver
		 * @return the builder
		 */
		@Override
		public EmailBuilders.Subject toName(String toName) {
			this.to = toName;
			return this;
		}

		/**
		 * Setting the subject of the email.
		 *
		 * @param subject of the email
		 * @return the builder
		 */
		@Override
		public EmailBuilders.Content subject(String subject) {
			this.subject = subject;
			return this;
		}

		@Override
		public EmailBuilders.Build content(String content) {
			this.content = content;
			return this;
		}

		/**
		 * Setting the cc of the email.
		 *
		 * @param ccEmail to be send the email
		 * @return the builder
		 */
		@Override
		public EmailBuilders.Build ccEmail(String ccEmail) {
			this.cc = ccEmail;
			return this;
		}

		/**
		 * Setting the attachments of the email.
		 *
		 * @param attachments to be send the email
		 * @return the builder
		 */
		@Override
		public EmailBuilders.Build attachments(String[] attachments) {
			this.attachments = attachments;
			return this;
		}

		/**
		 * Generating the email from the builder.
		 *
		 * @return generated {@link Email}
		 */
		@Override
		public Email build() {
			return new Email(from, to, subject, content, cc, attachments);
		}
	}
}
