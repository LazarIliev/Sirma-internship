package com.sirma.javacourse.javagui.downloadagent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.sirma.javacourse.inputoutput.utils.FileUtils;

class DownloadAgentTest {
	DownloadApp downloadApp = mock(DownloadApp.class);

	@Test
	void downloadFile_fromTheResourcesFolder_shouldWorkCorrect() throws IOException {
		File tempFile = File.createTempFile("picture", ".png");
		String filePath = String.valueOf(
				FileUtils.getFileFromResources("/DownloadAgentActivity.png", DownloadAgent.class).toURI());
		when(downloadApp.getFile()).thenReturn(tempFile);
		long expected = 16000;
		DownloadAgent downloadAgent = new DownloadAgent(downloadApp);

		downloadAgent.downloadFile(filePath);

		assertEquals(expected, tempFile.length());
		tempFile.deleteOnExit();
	}

	@Test
	void downloadFile_withWrongUrl_shouldGetZeroSize() throws IOException {
		File tempFile = File.createTempFile("picture", ".png");
		when(downloadApp.getFile()).thenReturn(tempFile);
		long expected = 0;
		DownloadAgent downloadAgent = new DownloadAgent(downloadApp);

		downloadAgent.downloadFile("ps://scx1.b-cdn.net/csz/news/800/2019/2-nature.jpg");

		assertEquals(expected, tempFile.length());
		tempFile.deleteOnExit();
	}
}