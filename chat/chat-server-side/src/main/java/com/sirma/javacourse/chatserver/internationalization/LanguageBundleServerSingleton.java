package com.sirma.javacourse.chatserver.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Singleton of the {@link ResourceBundle} of the server.
 */
public class LanguageBundleServerSingleton {
	private static final String SERVER_BUNDLE_FILE_NAME = "ServerBundle";
	private static final String EN_LANGUAGE = "en";
	private static final String US_COUNTRY = "US";

	private static ResourceBundle serverBundle = ResourceBundle.getBundle(SERVER_BUNDLE_FILE_NAME,
			new Locale(EN_LANGUAGE, US_COUNTRY));

	/**
	 * Protects from instantiation.
	 */
	private LanguageBundleServerSingleton() {
	}


	/**
	 * Returns the {@link ResourceBundle} of the server.
	 *
	 * @return the resource bundle of the server
	 */
	public static ResourceBundle getServerBundleInstance() {
		return serverBundle;
	}

	/**
	 * Sets the {@link Locale} of the {@link ResourceBundle}.
	 *
	 * @param locale the locale of the bundle
	 */
	public static void setServerLocale(Locale locale) {
		serverBundle = ResourceBundle.getBundle(SERVER_BUNDLE_FILE_NAME, locale);
	}
}
