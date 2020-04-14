package com.sirma.javacourse.threads.synchronizedthreads;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements {@link Runnable} and his method {@link Runnable#run} to run until stop is set to true
 * and count is less than maxCount.
 */
public class Counter implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Counter.class);
	private static final String MAX_COUNT_EXCEPTION_MESSAGE = "maxCount should be bigger than zero!";
	private static final int NUMBER_TO_CHECK_MAX_COUNT_VALIDATION = 1;
	private final Object lock;
	private final AtomicBoolean run;
	private int count;
	private int maxCount;

	/**
	 * Constructs a counter with zero count and run equal to true with a specified maxCount.
	 *
	 * @param run is {@link AtomicBoolean} to run the process until is set to false by another thread
	 * @param maxCount of the counter
	 * @throws IllegalArgumentException if maxCount is smaller than 1
	 */
	Counter(int maxCount, Object lock, AtomicBoolean run) {
		if (maxCount < NUMBER_TO_CHECK_MAX_COUNT_VALIDATION) {
			throw new IllegalArgumentException(MAX_COUNT_EXCEPTION_MESSAGE);
		}
		this.maxCount = maxCount;
		this.lock = lock;
		this.run = run;
	}

	/**
	 * Entry point.
	 * <p>
	 * Runs until count is less than maxCount.
	 * <p>
	 * On every loop {@link Counter} increment count with 1 and print the count and wait for the other thread to make the same and the loop continue until one of the threads reach the max count.
	 */
	@Override
	public void run() {
		try {
			boolean tempRun = true;
			while (count < maxCount && tempRun) {
				synchronized (lock) {
					incrementCount();
					logger.info(this + " : " + count);
					lock.notifyAll();
					lock.wait();
				}
					tempRun = run.get();
			}
			synchronized (lock) {
				run.set(false);
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			logger.info(e.getMessage(), e);
		}
	}

	/**
	 * Used for obtaining current value for the count.
	 *
	 * @return count.
	 */
	int getCount() {
		return count;
	}

	/**
	 * Increment the count.
	 */
	private void incrementCount() {
		count++;
	}
}
