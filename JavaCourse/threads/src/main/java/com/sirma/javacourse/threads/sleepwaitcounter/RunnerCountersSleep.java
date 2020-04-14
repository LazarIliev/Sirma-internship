package com.sirma.javacourse.threads.sleepwaitcounter;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runs two counters with a sleep method.
 */
public class RunnerCountersSleep {
	private static final Logger logger = LoggerFactory.getLogger(RunnerCountersSleep.class);

	public static void main(String[] args) throws InterruptedException {
		AtomicBoolean run = new AtomicBoolean(true);
		CounterSleep counterSleep = new CounterSleep(8, run);
		Thread thread1 = new Thread(counterSleep);
		CounterSleep counterSleep1 = new CounterSleep(20, run);
		Thread thread2 = new Thread(counterSleep1);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		logger.info(counterSleep + " " + counterSleep.getCount());
		logger.info(counterSleep1 + " " + counterSleep1.getCount());
	}
}
