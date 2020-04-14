package com.sirma.javacourse.reflection.greedyregex;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TagReplacerTest {

	@Test
	void replaceText_withCorrectData_shouldReplaceTags() {
		String text = "<x><b></b><x>Hello world</x>" + System.lineSeparator() + "<b>sdfsdf</b><x>Good" + System
				.lineSeparator() + "morning</x><x>69</x><x>sdfsdfsdf</x>" + System.lineSeparator() + "</x>";

		String actual = TagReplacer.replaceText(text);
		String expected =
				"<x><b></b><x/>" + System.lineSeparator() + "<b>sdfsdf</b><x/><x/><x/>" + System.lineSeparator()
						+ "</x>";

		assertEquals(expected, actual);
	}
}