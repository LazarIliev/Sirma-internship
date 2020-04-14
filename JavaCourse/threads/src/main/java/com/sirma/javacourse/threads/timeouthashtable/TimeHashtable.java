package com.sirma.javacourse.threads.timeouthashtable;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Store object for defined time. If objects are not used they are deleted from list.
 */
public class TimeHashtable {
	private Map<String, ExpiringObject> map;
	private int removeInterval;

	/**
	 * Initialize {@link ExpiredKeyRemover} with this instance of {@link TimeHashtable} and the specified interval of removal.
	 *
	 * @param removerInterval for which if an element is not used will be removed
	 * @param executor of {@link ScheduledExecutorService} for scheduling a instance of {@link ExpiredKeyRemover} to run on a specified interval
	 */
	public TimeHashtable(int removerInterval, ScheduledExecutorService executor) {
		this.map = new Hashtable<>();
		this.removeInterval = removerInterval;
		executor.scheduleAtFixedRate(new ExpiredKeyRemover(map), 0, removerInterval, TimeUnit.MILLISECONDS);
	}

	/**
	 * Remove object from the map.
	 */
	public synchronized void remove(String key) {
		map.keySet().removeIf(keyMap -> keyMap.equals(key));
	}

	/**
	 * Add object in map by specified key.
	 */
	public synchronized void put(String key, Object object) {
		remove(key);
		ExpiringObject expiringObject = new ExpiringObject(object, removeInterval);
		map.put(key, expiringObject);
	}

	/**
	 * Get object from the map by his key.
	 *
	 * @return the value for that key.
	 */
	public synchronized Object get(String key) {
		ExpiringObject expiryObj = map.get(key);
		Object obj = null;
		if (expiryObj != null) {
			obj = expiryObj.getObject();
		}
		return obj;
	}

	/**
	 * Gets all elements in the table.
	 *
	 * @return all elements in a single string
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<String, ExpiringObject> entry : map.entrySet()) {
			stringBuilder.append("key:").append(entry.getKey()).append(" element:")
					.append(entry.getValue().getObject()).append(System.lineSeparator());
		}
		return stringBuilder.toString().trim();
	}

	/**
	 * Call function for removing unused objects in last session.
	 */
	public static class ExpiredKeyRemover implements Runnable {
		private final Map<String, ExpiringObject> map;

		/**
		 * Initialize a {@link ExpiredKeyRemover} for the {@link TimeHashtable} with the specified interval of removal.
		 *
		 * @param map form which will be removed unused elements
		 */
		public ExpiredKeyRemover(Map<String, ExpiringObject> map) {
			this.map = map;
		}

		/**
		 * Remove elements with expired keys.
		 */
		@Override
		public void run() {
			map.values().removeIf(ExpiringObject::isExpired);
		}
	}
}
