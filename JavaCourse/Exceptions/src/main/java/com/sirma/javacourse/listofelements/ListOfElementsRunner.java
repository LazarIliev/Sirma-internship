package com.sirma.javacourse.listofelements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for the ListOfElements class.
 */
 public class ListOfElementsRunner {
	private static final Logger logger = LoggerFactory.getLogger(ListOfElementsRunner.class);

	 public static void main(String[] аrgs) {
		ListOfElements listOfElements = new ListOfElements(2);
		int firstElement = 3;
		String secondElement = "asd";
		int thirdElement = 7;

		try {
			listOfElements.add(firstElement);
			listOfElements.add(secondElement);
			listOfElements.add(thirdElement);
		} catch (FullArrayException | EmptyArrayException ex) {
			logger.info(ex.getMessage());
		} finally {
			listOfElements.printAllElements();
		}
	}
}
