package com.sirma.javacourse.threads.timeouthashtable;

/**
 * Class for holding an {@code Object} with an expiration timestamp.
 */
public class ExpiringObject {
	private final Object object;
	private long expirationTimestamp;
	private final long ttlInMillis;

	/**
	 * Creates an {@link ExpiringObject} instance with an {@link Object} and expiration timestamp.
	 *
	 * @param object to keep track of it
	 * @param ttlInMillis time in milliseconds for holding the object
	 */
	public ExpiringObject(Object object, long ttlInMillis) {
		this.object = object;
		this.expirationTimestamp = System.currentTimeMillis() + ttlInMillis;
		this.ttlInMillis = ttlInMillis;
	}

	/**
	 * Get the holding object and reset his timestamp.
	 *
	 * @return the object
	 */
	public Object getObject() {
		resetExpiring();
		return object;
	}

	/**
	 * Checks whether the expiration timestamp is expired or not.
	 *
	 * @return {@link Boolean} of the timestamp if it is expired
	 */
	public boolean isExpired() {
		return System.currentTimeMillis() > expirationTimestamp;
	}

	private void resetExpiring() {
		expirationTimestamp = System.currentTimeMillis() + ttlInMillis;
	}
}
