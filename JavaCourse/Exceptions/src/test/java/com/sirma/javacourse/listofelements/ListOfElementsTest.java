package com.sirma.javacourse.listofelements;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListOfElementsTest {
	private ListOfElements listOfElements;

	@BeforeEach
	void initializeListOfElements() {
		listOfElements = new ListOfElements(2);
	}

	@Test
	void add_withMoreElementsThanTheLength_shouldThrowException() {
		listOfElements.add(2);
		listOfElements.add(2);

		assertThrows(FullArrayException.class, () -> {listOfElements.add(3);});
	}

	@Test
	void remove_fromEmptyArray_shouldThrowException() {
		assertThrows(EmptyArrayException.class, () -> {listOfElements.remove();});
	}
}