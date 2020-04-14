package com.sirma.javacourse.objects.homogeneoustree;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a tree data structure.
 *
 * @param <T> is the generic type of which will be this tree.
 */
class Tree<T> {
	private static final Logger logger = LoggerFactory.getLogger(Tree.class);

	private TreeNode<T> root;

	/**
	 * Constructs the tree.
	 *
	 * @param value - the value of the node.
	 */
	Tree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		this.root = new TreeNode<T>(value);
	}

	/**
	 * Constructs the tree.
	 *
	 * @param value    - the value of the root node.
	 * @param children - the children of the root node.
	 */
	public Tree(T value, Tree<T>... children) {
		this(value);
		for (Tree<T> child : children) {
			this.root.addChild(child.root);
		}
	}

	/**
	 * @return the root node or null if the tree is empty.
	 */
	T getRootValue() {
		return this.root.getValue();
	}

	/**
	 * Inserts new value in the binary search tree.
	 *
	 * @param value - the value to be inserted.
	 */
	void insert(T value, T parent) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		TreeNode<T> parentNode = new TreeNode<T>(parent);

		this.root = insert(value, parentNode, root);
	}

	/**
	 * Traverses and prints the tree in
	 * Depth First Search (DFS) manner.
	 */
	void printDFS() {
		this.printDFS(this.root, "");
	}

	/**
	 * Inserts node in the tree by given value.
	 *
	 * @param value      - the new value.
	 * @param parentNode - the parent of the new node.
	 * @param node       - current node.
	 * @return the inserted node
	 */
	private TreeNode<T> insert(T value, TreeNode<T> parentNode, TreeNode<T> node) {

		if (node == null) {
			node = new TreeNode<T>(value);
			node.parent = parentNode;
		} else {
			if (node.getValue() == parentNode.getValue()) {
				node.addChild(new TreeNode<T>(value));
			} else {
				for (TreeNode<T> childNode : node.children) {
					if (childNode.getValue() == parentNode.getValue()) {
						childNode.addChild(new TreeNode<T>(value));
					} else {

						insert(value, parentNode, childNode);
					}
				}
			}
		}
		return node;
	}

	/**
	 * Traverses and prints tree in
	 * Depth First Search (DFS) manner.
	 *
	 * @param root   - the root of the tree
	 *               to be traversed.
	 * @param spaces - the spaces used for
	 *               representation of the parent-child relation.
	 */
	private void printDFS(TreeNode<T> root, String spaces) {
		if (this.root == null) {
			return;
		}

		logger.info(spaces + root.getValue() + System.lineSeparator());

		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			printDFS(child, spaces + " ");
		}
	}

	/**
	 * Represents a tree node.
	 */
	private static class TreeNode<T> {
		private T value;
		private boolean hasParent;
		private ArrayList<TreeNode<T>> children;

		TreeNode<T> parent;

		/**
		 * Constructs a tree node.
		 *
		 * @param value - the value of the node.
		 */
		TreeNode(T value) {
			if (value == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			this.value = value;
			this.children = new ArrayList<TreeNode<T>>();
		}

		/**
		 * @return the value of the node.
		 */
		T getValue() {
			return this.value;
		}

		/**
		 * Sets the value of the node.
		 *
		 * @param value - the value to be set.
		 */
		public void setValue(T value) {
			this.value = value;
		}

		/**
		 * Adds child to the node.
		 *
		 * @param child - the child to be added.
		 */
		void addChild(TreeNode<T> child) {
			if (child == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}
			if (child.hasParent) {
				throw new IllegalArgumentException("The node already has a parent!");
			}
			child.hasParent = true;//setting to true when is okey to add this child to that parent
			this.children.add(child);
		}

		/**
		 * Gets the child of the node at given index.
		 *
		 * @param index - the index of the desired child.
		 * @return the child on the given position.
		 */
		TreeNode<T> getChild(int index) {
			return this.children.get(index);
		}

		/**
		 * @return the number of node's children.
		 */
		int getChildrenCount() {
			return this.children.size();
		}
	}
}
