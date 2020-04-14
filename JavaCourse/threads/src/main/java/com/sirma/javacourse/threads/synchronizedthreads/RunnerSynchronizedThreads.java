package com.sirma.javacourse.threads.synchronizedthreads;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runs two counters which are synchronized and when one is counting the other is waiting and vise verse also print the counting for both of them until one reach his maxCount then both are stopped.
 */
public class RunnerSynchronizedThreads {
	private static final Logger logger = LoggerFactory.getLogger(RunnerSynchronizedThreads.class);

	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		AtomicBoolean run = new AtomicBoolean(true);
		Counter counter1 = new Counter(3, lock, run);
		Thread thread1 = new Thread(counter1);
		Counter counter2 = new Counter(10, lock, run);
		Thread thread2 = new Thread(counter2);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();

		logger.info(counter1 + " " + counter1.getCount());
		logger.info(counter2 + " " + counter2.getCount());
	}
}
