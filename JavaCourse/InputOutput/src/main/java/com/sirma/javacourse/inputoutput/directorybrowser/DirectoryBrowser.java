package com.sirma.javacourse.inputoutput.directorybrowser;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for listing directories of a directory or return file String if the given path includes a file name at the end.
 */
class DirectoryBrowser {
	private static final Logger logger = LoggerFactory.getLogger(DirectoryBrowser.class);

	/**
	 * Util class - no instantiation.
	 */
	private DirectoryBrowser() {
	}

	/**
	 * Lists the content of a directory, or a message that the given path lead to a file.
	 *
	 * @param path the path to the file/directory.
	 * @return "file" if the path lead to a file, directory if the path was to a directory.
	 */
	static String listContent(Path path) {
		File targetFile = new File(String.valueOf(path));
		if (targetFile.isDirectory()) {
			StringBuilder filesNames = new StringBuilder();
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
				for (Path file : stream) {
					filesNames.append(file.getFileName()).append(System.lineSeparator());
				}
			} catch (IOException e) {
				logger.info(e.getMessage(), e);
			}
			return filesNames.toString();
		} else {
			return "File";
		}
	}
}
