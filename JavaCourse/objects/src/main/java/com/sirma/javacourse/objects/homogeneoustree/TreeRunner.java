package com.sirma.javacourse.objects.homogeneoustree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeRunner {
	private static final Logger logger = LoggerFactory.getLogger(TreeRunner.class);

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>(2);

		tree.insert(3, 2);
		tree.insert(1, 3);
		tree.insert(3, 3);

		tree.printDFS();
	}
}
