package com.sirma.javacourse.objects.heterogeneoustree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinaryHeterogeneousTreeTest {

	@Test
	void printTree() {
		BinaryHeterogeneousTree binaryHeterogeneousTree = new BinaryHeterogeneousTree();
		binaryHeterogeneousTree.insert(10);
		binaryHeterogeneousTree.insert(100);
		binaryHeterogeneousTree.insert("str");
		binaryHeterogeneousTree.insert('s');
		binaryHeterogeneousTree.insert('1');
		binaryHeterogeneousTree.insert("tttt");
		binaryHeterogeneousTree.insert(2);
		binaryHeterogeneousTree.insert(9);
		binaryHeterogeneousTree.insert(8);
		binaryHeterogeneousTree.insert(11);

		String actual = binaryHeterogeneousTree.printTree();
		String expected = "2 8 9 10 11 1 100 s str tttt ";

		assertEquals(expected, actual);
	}
}