package com.sirma.javacourse.reflection.arrangmentofobjects;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for ordering ParentClass's children by priorityIndex.
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Priority {
	int priorityIndex();
}
