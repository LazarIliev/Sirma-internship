package com.sirma.javacourse.reflection.greedyregex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for replace a text.
 */
public class TagReplacerRunner {
	private static final Logger logger = LoggerFactory.getLogger(TagReplacerRunner.class);

	public static void main(String[] args) {
		String text = "<x><b></b><x>Hello world</x>" + System.lineSeparator() +
				"<b>sdfsdf</b><x>Good" + System.lineSeparator()
				+ "morning</x><x>69</x><x>sdfsdfsdf</x>" + System.lineSeparator() +
				"</x>";
		text = TagReplacer.replaceText(text);
		logger.info(text);
	}
}
