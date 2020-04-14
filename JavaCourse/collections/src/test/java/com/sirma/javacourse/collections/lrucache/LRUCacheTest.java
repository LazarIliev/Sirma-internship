package com.sirma.javacourse.collections.lrucache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class LRUCacheTest {

	@Test
	void constructor_withSmallCacheSize_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {LRUCache lruCache = new LRUCache(-1);});
	}

	@Test
	void display_withNormalInput_shouldWork() {
		LRUCache lruCache = new LRUCache(3);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);

		String expected = "{1=1, 2=2, 3=3}";

		assertEquals(expected, lruCache.toString());
	}

	@Test
	void display_addedMoreElements_shouldReturnSpecifiedNumberOfElements() {
		LRUCache lruCache = new LRUCache(3);

		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		String expected = "{2=2, 3=3, 4=4}";

		assertEquals(expected, lruCache.toString());
	}
}