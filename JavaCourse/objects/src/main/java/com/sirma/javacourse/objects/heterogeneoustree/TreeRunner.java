package com.sirma.javacourse.objects.heterogeneoustree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class.
 */
public class TreeRunner {
	private static final Logger logger = LoggerFactory.getLogger(TreeRunner.class);

	/**
	 * The entry point of the program.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryHeterogeneousTree binaryHeterogeneousTree = new BinaryHeterogeneousTree();

		binaryHeterogeneousTree.insert("stringsss");
		binaryHeterogeneousTree.insert(2);
		binaryHeterogeneousTree.insert(3);
		binaryHeterogeneousTree.insert("1");

		logger.info(binaryHeterogeneousTree.printTree());

	}
}
