package com.sirma.javacourse.javagui.messagereversal.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds a {@code List} of {@code MessageMemento}s. This class is part of the Memento design
 * pattern.
 */
public class MementoCaretaker {
	private List<MessageMemento> savedMementos = new ArrayList<>();
	private int index = -1;

	/**
	 * Adds new memento to the list and restart index.
	 *
	 * @param memento the memento to be added to the list
	 */
	public void addMemento(MessageMemento memento) {
		savedMementos.add(memento);
		restartIndex();
	}

	/**
	 * Returns the previous memento from the list.
	 *
	 * @return the previous memento from the list
	 */
	public MessageMemento getPreviousMemento() {
		if (index > 0) {
			return savedMementos.get(--index);
		}
		return null;
	}

	/**
	 * Returns the next memento from the list.
	 *
	 * @return the next memento from the list
	 */
	public MessageMemento getNextMemento() {
		if (index < savedMementos.size() - 1) {
			return savedMementos.get(++index);
		}
		return null;
	}

	/**
	 * Restart the index to the end of the list.
	 */
	private void restartIndex(){
		index = savedMementos.size();
	}
}
