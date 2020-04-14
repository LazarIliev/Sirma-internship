package com.sirma.javacourse.threads.counter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements {@link Runnable} interface and implements his method {@link Runnable#run}.
 */
public class Counter implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Counter.class);
	private static final String MAX_COUNT_EXCEPTION_MESSAGE = "maxCount should be bigger than zero!";
	private static final int MILLISECOND_TO_SLEEP = 1000;
	private static final int NUMBER_TO_CHECK_MAX_COUNT_VALIDATION = 1;
	private int count;
	private int maxCount;

	/**
	 * Constructs a counter with a specified maxCount.
	 *
	 * @param maxCount of the counter
	 * @throws IllegalArgumentException if maxCount is smaller than 1
	 */
	Counter(int maxCount) {
		if (maxCount < NUMBER_TO_CHECK_MAX_COUNT_VALIDATION) {
			throw new IllegalArgumentException(MAX_COUNT_EXCEPTION_MESSAGE);
		}
		this.maxCount = maxCount;
	}

	/**
	 * Entry point.
	 * <p>
	 * Runs until thread is interrupted or count equal to maxCount.
	 * <p>
	 * On every loop {@link Counter} wait 1 second and increment count with 1.
	 */
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted() && count < maxCount) {
			try {
				Thread.sleep(MILLISECOND_TO_SLEEP);
				incrementCount();
			} catch (InterruptedException e) {
				logger.info(e.getMessage(), e);
			}
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
