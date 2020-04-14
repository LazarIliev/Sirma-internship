package com.sirma.javacourse.threads.synchronizedthreads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.jupiter.api.Test;

class CounterTest {
	Object lock = new Object();
	AtomicBoolean run = new AtomicBoolean(true);

	@Test
	void constructor_withMaxCountLessThanOne_shouldThrowException() {

		assertThrows(IllegalArgumentException.class, () -> {new Counter(0, lock, run);});
	}

	@Test
	void run_withNormalInput_shouldWork() throws InterruptedException {
		Counter counter = new Counter(3, lock, run);
		Thread thread = new Thread(counter);
		Counter counter2 = new Counter(6, lock, run);
		Thread thread2 = new Thread(counter2);

		thread.start();
		thread2.start();
		thread.join();
		thread2.join();

		assertEquals(3, counter.getCount());
	}
}