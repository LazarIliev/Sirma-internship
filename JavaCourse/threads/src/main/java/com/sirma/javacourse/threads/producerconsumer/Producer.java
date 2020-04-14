package com.sirma.javacourse.threads.producerconsumer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Produces products to the {@link StoreHouse} on to the specified intervals of time.
 */
public class Producer implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final int TIME_TO_WAIT = 700;
	private StoreHouse storeHouse;
	private int time;

	/**
	 * Creates a new producer with default time to wait 700ms.
	 *
	 * @param storeHouse the storehouse in which the producer will add production
	 */
	public Producer(StoreHouse storeHouse) {
		this(storeHouse, TIME_TO_WAIT);
	}

	/**
	 * Creates a new producer with given time to wait.
	 *
	 * @param storeHouse the storehouse in which the producer will add production
	 * @param time time the producer to wait
	 */
	public Producer(StoreHouse storeHouse, int time) {
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
				String message = new Date().toString();
				logger.info("Producer : put -> " + message);
				storeHouse.put(message);
				wait(time);
			}
		} catch (InterruptedException e) {
			logger.info(e.getMessage(), e);
		}
	}
}
