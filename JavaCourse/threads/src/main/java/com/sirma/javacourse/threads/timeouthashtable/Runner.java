package com.sirma.javacourse.threads.timeouthashtable;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Runner class for instance of {@code TimeHashtable}.
 */
public class Runner {
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		TimeHashtable timeHashtable = new TimeHashtable(1500, executor);
		timeHashtable.put("key1", 1);
		timeHashtable.put("key2", 2);
		timeHashtable.put("key3", 3);
		timeHashtable.put("key1", 4);
		timeHashtable.remove("key3");
		timeHashtable.get("key2");
		Thread.sleep(1000);
		timeHashtable.get("key2");
		Thread.sleep(500);
		timeHashtable.get("key2");
		Thread.sleep(500);
		Thread.sleep(1000);
		String actual = timeHashtable.toString();
		executor.shutdown();
	}
}