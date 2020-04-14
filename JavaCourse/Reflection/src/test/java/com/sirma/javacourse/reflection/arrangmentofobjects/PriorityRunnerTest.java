package com.sirma.javacourse.reflection.arrangmentofobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PriorityRunnerTest {

	@Test
	void main_withCorrectData_shouldSortParentArray() {
		ParentClass[] actual = new ParentClass[3];
		actual[0] = new PriorityThird();
		actual[1] = new PrioritySecond();
		actual[2] = new PriorityFirst();
		Arrays.sort(actual, new AnnotationComparator());
		Assertions.assertAll(
				() ->assertEquals(PriorityFirst.class, actual[0].getClass()),
				() ->assertEquals(PrioritySecond.class, actual[1].getClass()),
				() ->assertEquals(PriorityThird.class, actual[2].getClass()));

	}
}