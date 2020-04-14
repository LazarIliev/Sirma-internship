package com.sirma.javacourse.threads.producerconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Consumes products on a specified interval of time from the {@link StoreHouse}.
 */
public class Consumer implements Runnable {

	private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
	private static final int TIME_TO_WAIT = 3000;
	private StoreHouse storeHouse;
	private int time;

	/**
	 * Creates a new consumer with default time to wait 3 seconds.
	 *
	 * @param storeHouse the storehouse from which the consumer will get production
	 */
	public Consumer(StoreHouse storeHouse) {
		this(storeHouse, TIME_TO_WAIT);
	}

	/**
	 * Creates a new consumer with given time to wait.
	 *
	 * @param storeHouse the storehouse from which the consumer will get production
	 * @param time time the consumer to wait
	 */
	public Consumer(StoreHouse storeHouse, int time) {
		this.storeHouse = storeHouse;
		this.time = time;
	}

	/**
	 * Entry point.
	 * <p>
	 * Runs until thread is interrupted.
	 */
	@Override
	public synchronized void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				String message = (String) storeHouse.get();
				logger.info(Thread.currentThread().getName() + " : get -> " + message);
				wait(time);
			}
		} catch (InterruptedException e) {
			logger.info(e.getMessage(), e);
		}
	}
}
