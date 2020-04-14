package com.sirma.javacourse.threads.timeouthashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.junit.jupiter.api.Test;

class TimeHashtableTest {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	@Test
	void put_withNormalInput_shouldWork() {
		TimeHashtable timeHashtable = new TimeHashtable(1000, executor);

		timeHashtable.put("key1", 1);
		timeHashtable.put("key2", 2);
		timeHashtable.put("key3", 3);
		String expected = "key:key3 element:3" + System.lineSeparator()
				+ "key:key2 element:2" + System.lineSeparator()
				+ "key:key1 element:1";
		String actual = timeHashtable.toString();

		assertEquals(expected, actual);
	}

	@Test
	void get_withNormalInput_shouldWork() {
		TimeHashtable timeHashtable = new TimeHashtable(1000, executor);

		timeHashtable.put("key1", 1);
		int expected = (int) timeHashtable.get("key1");
		assertEquals(expected, 1);
	}

	@Test
	void remove_withNormalInput_shouldWork() {
		TimeHashtable timeHashtable = new TimeHashtable(1000, executor);

		timeHashtable.put("key1", 1);
		timeHashtable.remove("key1");
		assertEquals("", timeHashtable.toString());
	}
}