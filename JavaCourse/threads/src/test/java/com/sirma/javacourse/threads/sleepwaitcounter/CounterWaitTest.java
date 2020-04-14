package com.sirma.javacourse.threads.sleepwaitcounter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;

class CounterWaitTest {
	AtomicBoolean run = new AtomicBoolean(true);

	@Test
	void constructor_withMaxCountLessThanOne_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {new CounterWait(0, run);});
	}

	@Test
	void run() throws InterruptedException {
		CounterWait counterWait = new CounterWait(3, run);
		Thread thread = new Thread(counterWait);

		thread.start();
		thread.join();

		assertEquals(3, counterWait.getCount());
	}
}