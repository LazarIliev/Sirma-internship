package com.sirma.javacourse.threads.synchronizedstack;

/**
 * Thread for adding items to {@code ListOfElements}.
 */
public class AddThread implements Runnable {

	private ListOfElements list;
	private Object itemToAdd;

	/**
	 * Creates a new thread for adding items to ListOfElements.
	 *
	 * @param list in which items will be added
	 * @param itemToAdd the item to be added to the list
	 */
	public AddThread(ListOfElements list, Object itemToAdd) {
		this.list = list;
		this.itemToAdd = itemToAdd;
		new Thread(this).start();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		list.addItem(itemToAdd);
	}
}
