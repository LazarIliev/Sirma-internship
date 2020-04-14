package com.sirma.javacourse.reflection.arrangmentofobjects;

import java.util.Arrays;

/**
 * Create Array whit elements that will be sorted by priority.
 */
public class PriorityRunner {
	public static void main(String[] args) {
		ParentClass[] list = new ParentClass[3];
		list[0] = new PriorityThird();
		list[1] = new PrioritySecond();
		list[2] = new PriorityFirst();
		Arrays.sort(list, new AnnotationComparator());
	}
}
