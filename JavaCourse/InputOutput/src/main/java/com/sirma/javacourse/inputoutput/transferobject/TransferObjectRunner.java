package com.sirma.javacourse.inputoutput.transferobject;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

/**
 * Runner class for TransferObject's transfer method.
 */
public class TransferObjectRunner {
	private static final Logger logger = LoggerFactory.getLogger(TransferObjectRunner.class);

	public static void main(String[] args) {
		String fileName = "/transferObject.txt";
		List<String> fileInputLines = FileUtils.readFile(fileName, TransferObjectRunner.class);

		try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
				new ByteArrayInputStream(fileInputLines.toString().getBytes()));
				ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream()) {

			TransferObject objectTransfer = new TransferObject(bufferedInputStream, byteOutputStream);
			long num = objectTransfer.transfer(8, 10);
			logger.info(String.valueOf(num));
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}
}
