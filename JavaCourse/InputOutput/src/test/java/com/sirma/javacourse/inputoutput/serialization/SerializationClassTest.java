package com.sirma.javacourse.inputoutput.serialization;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

class SerializationClassTest {

	@Test
	void getObject_withCorrectData_shouldWork() throws IOException {
		UserDefinedObject userObject = new UserDefinedObject("Pesho");
		SerializationClass objectManipulator = new SerializationClass();
		File temp = File.createTempFile("userDefinedObject", "usr");
		String path = temp.getPath();

		try (FileOutputStream fileOutput = new FileOutputStream(temp);
				ObjectOutputStream output = new ObjectOutputStream(fileOutput)) {
			output.writeObject(userObject);

		}
		UserDefinedObject loadedUserObject = objectManipulator.getObject(path);
		assertEquals("Pesho", loadedUserObject.getName());
		temp.deleteOnExit();
	}
}