package com.sirma.javacourse.collections.pagebean;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class PageBeanTest {

	@Test
	void constructor_withNegativePageSize_shouldThrowIllegalArgumentException() {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);

		assertThrows(IllegalArgumentException.class, () -> new PageBean<>(list, -2));
	}

	@Test
	void constructor_withZeroPageSize_shouldThrowIllegalArgumentException() {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);

		assertThrows(IllegalArgumentException.class, () -> new PageBean<>(list, 0));
	}

	@Test
	void next_normalCase_shouldWork() {
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(3);
		list.add(-5);
		list.add(-5);
		List<Integer> expected = new ArrayList<>();
		expected.add(list.get(2));
		expected.add(list.get(3));

		PageBean pageBean = new PageBean<>(list, 2);
		List actual = pageBean.next();

		assertArrayEquals(expected.toArray(), actual.toArray());
	}
}