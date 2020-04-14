package com.sirma.javacourse.threads.sleepwaitcounter;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runs two counters with a wait method.
 */
public class RunnerCountersWait {
	private static final Logger logger = LoggerFactory.getLogger(RunnerCountersWait.class);

	public static void main(String[] args) throws InterruptedException {
		AtomicBoolean run = new AtomicBoolean(true);
		CounterWait counterWait = new CounterWait(2, run);
		Thread thread1 = new Thread(counterWait);
		CounterWait counterWait1 = new CounterWait(20, run);
		Thread thread2 = new Thread(counterWait1);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		logger.info(counterWait + " " + counterWait.getCount());
		logger.info(counterWait1 + " " + counterWait1.getCount());
	}
}
