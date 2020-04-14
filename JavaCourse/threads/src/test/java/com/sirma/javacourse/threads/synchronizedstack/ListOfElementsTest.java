package com.sirma.javacourse.threads.synchronizedstack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

class ListOfElementsTest {

	@Test
	void add_normalCase_shouldWork() throws InterruptedException, ExecutionException {
		ListOfElements list = new ListOfElements(3);

		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> list.add(3));
		future.get();

		String expected = "[3, null, null]";
		String actual = list.getAllElements();

		assertEquals(expected, actual);
	}
}