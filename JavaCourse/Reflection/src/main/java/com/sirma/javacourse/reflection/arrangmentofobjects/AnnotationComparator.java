package com.sirma.javacourse.reflection.arrangmentofobjects;

import java.util.Comparator;

/**
 * Read annotation values and determine which is with a bigger priorityIndex.
 */
class AnnotationComparator implements Comparator<ParentClass> {
	/**
	 * Compare annotation values on objects.
	 */
	@Override
	public int compare(ParentClass firstClass, ParentClass secondClass) {
		int firstPriority = firstClass.getClass().getAnnotation(Priority.class).priorityIndex();
		int secondPriority = secondClass.getClass().getAnnotation(Priority.class).priorityIndex();
		return firstPriority - secondPriority;
	}
}
