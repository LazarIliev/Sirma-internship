package com.sirma.javacourse.objects.homogeneoustree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TreeTest {

	@Test
	void getRootValue_withCorrectData_shouldWorkCorrect() {
		Tree<Integer> tree = new Tree<>(2);

		tree.insert(9, 2);
		tree.insert(7, 2);
		tree.insert(27, 9);
		tree.insert(33, 9);

		int actual = tree.getRootValue();
		int expected = 2;
		assertEquals(expected, actual);

	}
}