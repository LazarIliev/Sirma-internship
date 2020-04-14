package com.sirma.javacourse.threads.sleepwaitcounter;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CounterSleep implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(CounterWait.class);
	private static final String MAX_COUNT_EXCEPTION_MESSAGE = "maxCount should be bigger than zero!";
	private static final int MILLISECOND_TO_SLEEP = 1000;
	private static final int NUMBER_TO_CHECK_MAX_COUNT_VALIDATION = 1;
	private AtomicBoolean run;
	private int count;
	private int maxCount;

	/**
	 * Constructs a counter with zero count and run equal to true with a specified maxCount.
	 *
	 * @param run is {@link AtomicBoolean}
	 * @param maxCount of the counter
	 * @throws IllegalArgumentException if maxCount is smaller than 1
	 */
	CounterSleep(int maxCount, AtomicBoolean run) {
		if (maxCount < NUMBER_TO_CHECK_MAX_COUNT_VALIDATION) {
			throw new IllegalArgumentException(MAX_COUNT_EXCEPTION_MESSAGE);
		}
		this.maxCount = maxCount;
		this.run = run;
	}

	/**
	 * Entry point.
	 * <p>
	 * Runs until run is set to false and count is less than maxCount.
	 * <p>
	 * On every loop increment count with 1 and wait 1 second  in this case uses a {@link Thread#sleep(long)} and print the count.
	 */
	@Override
	public void run() {
		while (count < maxCount && run.get()) {
			try {
				incrementCount();
				Thread.sleep(MILLISECOND_TO_SLEEP);
				logger.info(this + " : " + count);
			} catch (InterruptedException e) {
				logger.info(e.getMessage(), e);
			}
		}
		run.set(false);
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
