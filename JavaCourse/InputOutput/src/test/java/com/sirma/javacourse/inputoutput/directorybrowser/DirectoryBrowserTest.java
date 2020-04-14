package com.sirma.javacourse.inputoutput.directorybrowser;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectoryBrowserTest {

	@Test
	void listContent_withDirectoryInput_shouldWork() throws URISyntaxException {
		URI resource = DirectoryBrowserRunner.class.getResource("").toURI();
		Path path = Paths.get(resource);
		String actual = DirectoryBrowser.listContent(path);
		String expected = "DirectoryBrowserTest.class" + System.lineSeparator();

		Assertions.assertEquals(expected, actual);
	}

	@Test
	void listContent_withFileInput_shouldWork() throws  URISyntaxException {
		URI resource = DirectoryBrowserRunner.class.getResource("/change.txt").toURI();
		Path path = Paths.get(resource);

		String actual = DirectoryBrowser.listContent(path);
		String expected = "File";

		Assertions.assertEquals(expected, actual);
	}

}