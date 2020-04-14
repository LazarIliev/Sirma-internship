package com.sirma.javacourse.threads.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CounterTest {

	@Test
	void constructor_withMaxCountLessThanOne_shouldThrowException(){
		assertThrows(IllegalArgumentException.class, () ->{new Counter(0);});
	}

	@Test
	void run_withNormalInput_shouldWork() throws InterruptedException {
		Counter counter = new Counter(3);
		Thread counterThread = new Thread(counter);

		counterThread.start();
		Thread.sleep(4000);

		assertEquals(3, counter.getCount());
	}

	@Test
	void run_withSetStopImmediately_countShouldBeLessThanMaxCount() {
		Counter counter = new Counter(20);
		Thread counterThread = new Thread(counter);

		counterThread.start();
		boolean isCountLessThanMaxCount = counter.getCount() < 20;

		assertTrue(isCountLessThanMaxCount);
	}
}