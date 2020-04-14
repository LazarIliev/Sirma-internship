package com.sirma.javacourse.reflection.instance;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

class ReflectionInfoInstanceOfClassRunnerTest {
	private ClassForInstance instance = new ClassForInstance();

	@Test
	void listInterfaces_withCorrectData_shouldWork() {
		String actual = ReflectionInfoInstanceOfClass.listInterfaces(ClassForInstance.class.getName());
		String fileName = "/listInterfaces.txt";
		String ex = FileUtils.readFileContentAsString(fileName, ReflectionInfoInstanceOfClassRunnerTest.class).trim();

		Assertions.assertEquals(ex, actual);
	}

	@Test
	void getParent_withCorrectData_shouldWork() {
		String actual = ReflectionInfoInstanceOfClass.getParent(instance);
		String expected = "Super class:class java.lang.Object";

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void createFromName_withCorrectData_shouldWork() {
		ClassForInstance actual = (ClassForInstance) ReflectionInfoInstanceOfClass.createFromName(
				ClassForInstance.class);

		assertThat(actual, instanceOf(ClassForInstance.class));
	}
}