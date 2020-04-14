package com.sirma.javacourse.inputoutput.transferobject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for transferring a content of an {@link InputStream} to buffer.
 */
public class TransferObject {
	private static final Logger logger = LoggerFactory.getLogger(TransferObject.class);

	private InputStream input;
	private OutputStream output;

	/**
	 * The constructor taking in an instance of an {@link InputStream}.
	 *
	 * @param input the instance of the input stream
	 */
	public TransferObject(InputStream input, OutputStream output) {
		this.input = input;
		this.output = output;
	}

	/**
	 * Transfers the content of the {@link InputStream} to the byte[] buffer and returns the bytes
	 * transferred if offset is bigger than the length of the {@link InputStream}.
	 *
	 * @param numberOfBytes the number of bytes to be transferred
	 * @param offset the offset at which the transfer starts
	 * @return the number of bytes successfully transferred
	 */
	public int transfer(int numberOfBytes, int offset) {
		int read = 0;
		try {
			input.skip(offset);

			byte[] buff = new byte[numberOfBytes];

			read = input.read(buff, 0, numberOfBytes);

			if (read == -1) {
				return read;
			}
			output.write(buff, 0, read);
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
		return read;
	}
}
