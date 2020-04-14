package com.sirma.javacourse.chatclient.internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Singleton of the {@link ResourceBundle} of the client.
 */
public class LanguageBundleClientSingleton {
	private static final String CLIENT_BUNDLE_FILE_NAME = "ClientBundle";
	private static final String CLIENT_LOGIN_BUNDLE_FILE_NAME = "ClientLoginBundle";
	private static final String EN_LANGUAGE = "en";
	private static final String US_COUNTRY = "US";

	private static ResourceBundle clientLoginBundle = ResourceBundle.getBundle(
			CLIENT_LOGIN_BUNDLE_FILE_NAME, new Locale(EN_LANGUAGE, US_COUNTRY));
	private static ResourceBundle clientBundle = ResourceBundle.getBundle(CLIENT_BUNDLE_FILE_NAME,
			new Locale(EN_LANGUAGE, US_COUNTRY));

	/**
	 * Protects from instantiation.
	 */
	private LanguageBundleClientSingleton() {
	}

	/**
	 * Returns the {@link ResourceBundle} of the client login form.
	 *
	 * @return the resource bundle of the client login form
	 */
	public static ResourceBundle getClientLoginBundleInstance() {
		return clientLoginBundle;
	}

	/**
	 * Sets the {@link Locale} of the {@link ResourceBundle} for the client login form.
	 *
	 * @param locale the locale of the bundle for the client login form
	 */
	public static void setClientLoginLocale(Locale locale) {
		clientLoginBundle = ResourceBundle.getBundle(CLIENT_LOGIN_BUNDLE_FILE_NAME, locale);
	}


	/**
	 * Returns the {@link ResourceBundle} of the client.
	 *
	 * @return the resource bundle of the client
	 */
	public static ResourceBundle getClientBundleInstance() {
		return clientBundle;
	}

	/**
	 * Sets the {@link Locale} of the {@link ResourceBundle} for the client.
	 *
	 * @param locale the locale of the bundle for the client
	 */
	public static void setClientLocale(Locale locale) {
		clientBundle = ResourceBundle.getBundle(CLIENT_BUNDLE_FILE_NAME, locale);
	}
}
