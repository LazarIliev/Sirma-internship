package com.sirma.javacourse.objects.homogeneoustree.binary;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	private BinaryTree binaryTree;

	@BeforeEach
	void initializeTree() {
		binaryTree = new BinaryTree();
	}

	@Test
	void insert() {

		binaryTree.insert(44);
		binaryTree.insert(10);

		int expectedValue = Integer.parseInt(String.valueOf(binaryTree.getLeftChildNode()));
		int actualValue = 10;

		assertEquals(expectedValue, actualValue);
	}

	@Test
	void find() {
		binaryTree.insert(4);
		binaryTree.insert(10);
		binaryTree.insert(11);
		binaryTree.insert(19);
		binaryTree.insert(100);

		int expectedValue = Integer.valueOf(String.valueOf(binaryTree.find(11)));

		int actualValue = 11;

		assertEquals(expectedValue, actualValue);
	}

	@Test
	void getRightChildNode() {
		binaryTree.insert(44);
		binaryTree.insert(10);
		binaryTree.insert(45);

		int expectedValue = Integer.parseInt(String.valueOf(binaryTree.getRightChildNode()));
		int actualValue = 45;

		assertEquals(expectedValue, actualValue);
	}
}