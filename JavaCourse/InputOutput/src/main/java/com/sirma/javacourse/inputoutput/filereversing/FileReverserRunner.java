package com.sirma.javacourse.inputoutput.filereversing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

/**
 * Runner class for FileReverser
 */
public class FileReverserRunner {
	private static final Logger logger = LoggerFactory.getLogger(FileReverserRunner.class);

	public static void main(String[] args) {
		String fileName = "/reversingFile.txt";

		logger.info(FileUtils.readFile(fileName, FileReverserRunner.class).toString());
		FileReverser.saveFileReversed(fileName, FileReverserRunner.class);
		logger.info(FileUtils.readFile(fileName, FileReverserRunner.class).toString());
	}
}
