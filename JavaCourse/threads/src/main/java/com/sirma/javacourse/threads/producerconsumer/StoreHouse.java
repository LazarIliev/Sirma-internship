package com.sirma.javacourse.threads.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a storehouse for the Producer-Consumer task. Thread safe.
 */
public class StoreHouse {
	private static final Logger logger = LoggerFactory.getLogger(StoreHouse.class);
	private Queue<Object> queue;
	private int size;

	/**
	 * Creates a new storehouse with given size.
	 *
	 * @param size of the storehouse
	 */
	public StoreHouse(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException(
					"The store house's size cannot be under or equal to zero");
		}

		this.size = size;
		this.queue = new LinkedList<>();
	}

	/**
	 * Puts new production.
	 *
	 * @param obj production to be added storehouse
	 */
	public synchronized void put(Object obj) {
		while (queue.size() == size) {
			try {
				wait();
			} catch (InterruptedException e) {
				logger.info(e.getMessage());
			}
		}

		queue.add(obj);
		notify();
	}

	/**
	 * Returns first added production.
	 *
	 * @return the first added production to the storehouse
	 */
	public synchronized Object get() {
		while (queue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				logger.info(e.getMessage());
			}
		}

		Object obj = queue.poll();
		notify();
		return obj;
	}

	/**
	 * Returns the left number of stocks in the store house.
	 *
	 * @return the left number of stocks in the store house.
	 */
	public synchronized int getLeftSize() {
		return queue.size();
	}
}
