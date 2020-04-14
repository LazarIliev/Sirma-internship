package com.sirma.javacourse.objects.homogeneoustree.binary;

public class BinaryRunner {
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();

		binaryTree.insert(4);
		binaryTree.insert(9);
		binaryTree.insert(1);
		binaryTree.insert(7);

		binaryTree.printPreOrder();
	}
}
