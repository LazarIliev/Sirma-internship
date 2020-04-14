package com.sirma.javacourse.threads.synchronizedstack;

/**
 * Thread for removing items from {@code ListOfElements}.
 */
public class RemoveThread implements Runnable {

	private ListOfElements list;

	/**
	 * Creates a new thread for removing item from ListOfElements.
	 *
	 * @param list from which items to be removed
	 */
	public RemoveThread(ListOfElements list) {
		this.list = list;
		new Thread(this).start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		list.removeItem();
	}
}
