package com.sirma.javacourse.reflection.greedyregex;

/**
 * Replace a text by a specific criteria.
 */
class TagReplacer {
	/**
	 * Util class - no instantiation.
	 */
	TagReplacer() {
	}

	static String replaceText(String text){
		return text.replaceAll("<x[^<]*[^>]/x>", "<x/>");
	}
}
