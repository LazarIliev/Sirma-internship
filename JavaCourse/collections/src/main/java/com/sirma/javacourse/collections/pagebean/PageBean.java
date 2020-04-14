package com.sirma.javacourse.collections.pagebean;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implements a class that divides a list of elements into pages and executes methods on the split list of pages using commands from the console.
 * <p>
 * For each command entered through the console, a concurrent method is executed on the split page collection.
 */
class PageBean<T> {
	private static final Logger logger = LoggerFactory.getLogger(PageBean.class);
	private static final String EXIT_PROGRAM_STRING = "exit";
	private static final String NEXT_PROGRAM_COMMAND = "n";
	private static final String HAS_NEXT_PROGRAM_COMMAND = "n?";
	private static final String PREVIOUS_PROGRAM_COMMAND = "p";
	private static final String HAS_PREVIOUS_PROGRAM_COMMAND = "p?";
	private static final String CURRENT_PAGE_NUMBER_PROGRAM_COMMAND = "pn";
	private static final String FIRST_PAGE_PROGRAM_COMMAND = "f";
	private static final String LAST_PAGE_PROGRAM_COMMAND = "l";

	private List<T> elements;
	private int pageSize;
	private int currentPage;

	/**
	 * Creates a new PageBean with given list and how many elements to be paged on every page, also set current page to zero.
	 *
	 * @param elements the list to be paged
	 * @param pageSize the each page's number of elements to show
	 * @throws IllegalArgumentException if the pageSize is negative or equal to zero
	 */
	PageBean(List<T> elements, int pageSize) {
		if (pageSize <= 0) {
			throw new IllegalArgumentException("The given page size cannot be equal or under zero");
		}
		this.elements = elements;
		this.pageSize = pageSize;
		currentPage = 0;
	}

	/**
	 * Start PageBean from the first page and printing it.
	 * <p>
	 * Read commands from the console in while loop and execute them for the exact method until receive the exit command.
	 */
	void startPageBean() {
		String firstPage = this.firstPage().toString();
		logger.info(firstPage);
		logger.info(" - Page #" + this.getCurrentPageNumber());
		String result = "";
		try (Scanner reader = new Scanner(System.in)) {
			String line = reader.nextLine().trim();
			while (!EXIT_PROGRAM_STRING.equals(line)) {
				switch (line) {
					case HAS_NEXT_PROGRAM_COMMAND:
						result = hasNext() ? "true" : "false";
						break;
					case NEXT_PROGRAM_COMMAND:
						result = next().toString();
						break;
					case PREVIOUS_PROGRAM_COMMAND:
						result = previous().toString();
						break;
					case CURRENT_PAGE_NUMBER_PROGRAM_COMMAND:
						result = String.valueOf(getCurrentPageNumber());
						break;
					case FIRST_PAGE_PROGRAM_COMMAND:
						result = firstPage().toString();
						break;
					case LAST_PAGE_PROGRAM_COMMAND:
						result = lastPage().toString();
						break;
					case HAS_PREVIOUS_PROGRAM_COMMAND:
						result = hasPrevious() ? "true" : "false";
						break;
					default:
				}
				logger.info(result);
				line = reader.nextLine().trim().toLowerCase();
			}
		}
	}

	/**
	 * Gets the next page of the bean.
	 *
	 * @return a list of the next elements
	 * @throws IndexOutOfBoundsException if there is no next page
	 */
	List<T> next() {
		if (!hasNext()) {
			throw new IndexOutOfBoundsException("You passed the end of the pages!");
		}
		currentPage++;
		return getElements();
	}

	/**
	 * Gets the current page number.
	 *
	 * @return the current page number.
	 */
	int getCurrentPageNumber() {
		return currentPage + 1;
	}

	/**
	 * Determines if the bean has a next available page.
	 *
	 * @return true if there is a next page.
	 */
	boolean hasNext() {
		if (currentPage == 0) {
			return (currentPage + 1) * pageSize <= elements.size();
		}
		return currentPage * pageSize <= elements.size();
	}

	/**
	 * Gets the previous page of the bean.
	 *
	 * @return a list of the previous elements.
	 */
	List<T> previous() {
		if (!hasPrevious()) {
			throw new IndexOutOfBoundsException("You are already at the first page!");
		}
		currentPage--;
		return getElements();
	}

	/**
	 * Determines if the bean has a previous available page.
	 *
	 * @return true if there is a previous page.
	 */
	boolean hasPrevious() {
		return currentPage > 0;
	}

	/**
	 * Switches the bean to the first page.
	 *
	 * @return the elements on the first page.
	 */
	List<T> firstPage() {
		currentPage = 0;
		return getElements();
	}

	/**
	 * Switches the bean to the last page.
	 *
	 * @return the elements on the last page.
	 */
	List<T> lastPage() {
		if ((elements.size() % pageSize) == 0) {
			currentPage = elements.size() / pageSize - 1;
		} else {
			currentPage = elements.size() / pageSize;
		}
		return getElements();
	}

	/**
	 * Gets the current page of the bean. The amount of records returned is dependent on the page
	 * size used in the constructor of the class.
	 *
	 * @return a list of the next elements.
	 */
	private List<T> getElements() {
		int startIndex = currentPage * pageSize;
		int endIndex = startIndex + pageSize;
		if (!hasNext()) {
			endIndex = elements.size() - 1;
		}
		return elements.subList(startIndex, endIndex);
	}
}
