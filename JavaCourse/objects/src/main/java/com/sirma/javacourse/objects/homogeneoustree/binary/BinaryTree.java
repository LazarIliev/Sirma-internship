package com.sirma.javacourse.objects.homogeneoustree.binary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a binary tree structure
 */
class BinaryTree<Integer> {
	private static final Logger logger = LoggerFactory.getLogger(BinaryTree.class);

	private BinaryTreeNode<Integer> root;

	/**
	 * Inserts new value in the binary search tree, only if there is not already a number with same value.
	 *
	 * @param value the value to be inserted.
	 */
	void insert(Integer value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		this.root = insert(value, null, root);
	}

	/**
	 * Finds a given value in the tree and returns the node
	 * which contains it if such exists.
	 *
	 * @param value the value to be found.
	 * @return the found node or null if not found.
	 */
	BinaryTreeNode<Integer> find(Integer value) {
		BinaryTreeNode<Integer> node = this.root;
		int valueToFind = java.lang.Integer.parseInt(value.toString());
		int valueNode = java.lang.Integer.parseInt(node.value.toString());
		while (node != null) {
			if (valueToFind < valueNode) {
				node = node.leftChild;
			} else if (valueToFind > valueNode) {
				node = node.rightChild;
			} else {
				break;
			}
		}
		return node;
	}

	/**
	 * @return the left child of the root.
	 */
	BinaryTreeNode<Integer> getLeftChildNode() {
		if (this.root != null) {
			return this.root.getLeftChild();
		}
		return null;
	}

	/**
	 * @return the right child of the root.
	 */
	BinaryTreeNode<Integer> getRightChildNode() {
		if (this.root != null) {
			return this.root.getRightChild();
		}
		return null;
	}

	/**
	 * Traverses and prints the binary
	 * tree in pre-order manner.
	 */
	void printPreOrder() {
		printPreOrder(this.root);
	}

	/**
	 * Traverses binary tree in pre-order manner.
	 *
	 * @param root the binary tree to be traversed.
	 */
	private void printPreOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		// 1. Visit the left child.
		printPreOrder(root.getLeftChild());
		// 2. Visit the root of this subtree.
		logger.info(root.getValue() + " ");
		// 3. Visit the right child.
		printPreOrder(root.getRightChild());
	}

	/**
	 * Inserts node in the binary search tree by given value.
	 *
	 * @param value the new value.
	 * @param parentNode the parent of the new node.
	 * @param node current node.
	 * @return the inserted node
	 */
	private BinaryTreeNode<Integer> insert(Integer value, BinaryTreeNode<Integer> parentNode,
			BinaryTreeNode<Integer> node) {
		if (node == null) {
			node = new BinaryTreeNode<Integer>(value);
			node.parent = parentNode;
		} else {

			if ((int) value < (int) node.value) {
				node.leftChild = insert(value, node, node.leftChild);
			} else if ((int) value > (int) node.value) {
				node.rightChild = insert(value, node, node.rightChild);
			}
		}
		return node;
	}

	/**
	 * Represents a binary tree node.
	 */
	private static class BinaryTreeNode<Integer> {
		Integer value;
		BinaryTreeNode<Integer> parent;
		BinaryTreeNode<Integer> leftChild;
		BinaryTreeNode<Integer> rightChild;

		/**
		 * Constructs the tree node.
		 *
		 * @param value the new value.
		 */
		BinaryTreeNode(Integer value) {
			this.value = value;
		}

		@Override public String toString() {
			return this.value.toString();
		}

		@Override public int hashCode() {
			return this.value.hashCode();
		}

		@Override public boolean equals(Object obj) {
			BinaryTreeNode<Integer> other = (BinaryTreeNode<Integer>) obj;
			return this.value == other.value;
		}

		/**
		 * @return the left child or null if it does not exists.
		 */
		BinaryTreeNode<Integer> getLeftChild() {
			return this.leftChild;
		}

		/**
		 * @return the right child or null if it does not exists.
		 */
		BinaryTreeNode<Integer> getRightChild() {
			return this.rightChild;
		}

		/**
		 * @return the value of the node.
		 */
		Integer getValue() {
			return this.value;
		}
	}
}
