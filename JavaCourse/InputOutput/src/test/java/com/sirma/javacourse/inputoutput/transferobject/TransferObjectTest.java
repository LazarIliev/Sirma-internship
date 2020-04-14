package com.sirma.javacourse.inputoutput.transferobject;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

class TransferObjectTest {

	@Test
	void transfer_withCorrectInput_shouldReturnCorrectInt() throws IOException {
		String fileName = "/transferObject.txt";
		List<String> linesInput = FileUtils.readFile(fileName, TransferObjectTest.class);
		long num;
		try (BufferedInputStream br = new BufferedInputStream(
				new ByteArrayInputStream(linesInput.toString().getBytes()));
				ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream()) {
			TransferObject objectTransfer = new TransferObject(br, byteOutputStream);
			num = objectTransfer.transfer(12, 6);
		}

		Assertions.assertEquals(12, num);
	}
}