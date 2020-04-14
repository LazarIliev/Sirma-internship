package com.sirma.javacourse.collections.lrucache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shows how the LRUCache class can be used.
 */
public class RunnerLRU {
	private static final Logger logger = LoggerFactory.getLogger(RunnerLRU.class);

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(4);
		lruCache.put(1, 1);
		lruCache.put(2, 2);
		lruCache.put(3, 3);
		lruCache.put(4, 4);
		lruCache.put(5, 5);
		logger.info(lruCache.toString());
	}
}
