package com.sirma.javacourse.threads.twocounters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;

class CounterTest {
	private AtomicBoolean run = new AtomicBoolean(true);

	@Test
	void constructor_withMaxCountLessThanOne_shouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {new Counter(0, run);});
	}

	@Test
	void run_withNormalInput_shouldWork() throws InterruptedException {
		Counter counter = new Counter(3, run);
		Thread thread = new Thread(counter);

		thread.start();
		thread.join();

		assertEquals(3, counter.getCount());
	}
}