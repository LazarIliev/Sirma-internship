package com.sirma.javacourse.collections.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class for simple LRU Cache Implementation extending  {@code LinkedHashMap} in AccessOrder with fixed capacity.
 */
class LRUCache extends LinkedHashMap<Integer, Integer> {
	private int maxSize;

	/**
	 * Constructs a LRU cache with fixed capacity.
	 *
	 * @param capacity the fixed capacity
	 */
	LRUCache(int capacity) {
		super(capacity, 0.75f, true);
		this.maxSize = capacity;
	}

	/**
	 * Get a value by key.
	 *
	 * @param key of the value
	 * @return value for the related key if it exists
	 */
	int get(int key) {
		return super.get(key);
	}

	/**
	 * Put a value with the key in the {@code LRUCache}.
	 *
	 * @param key of the value
	 * @param value of the key
	 */
	void put(int key, int value) {
		super.put(key, value);
	}

	/**
	 * Remove the eldest entry.
	 *
	 * @param eldest entry to be removed
	 * @return if the size of the map is bigger than the fixed size of the {@code LRUCache} capacity.
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return this.size() > maxSize;
	}
}