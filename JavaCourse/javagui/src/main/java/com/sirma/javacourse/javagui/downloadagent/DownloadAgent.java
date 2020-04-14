package com.sirma.javacourse.javagui.downloadagent;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sirma.javacourse.inputoutput.transferobject.TransferObject;

/**
 * Download files from url. Update progress.
 */
public class DownloadAgent {
	private static final Logger logger = LoggerFactory.getLogger(DownloadAgent.class);
	private DownloadApp downloadApp;
	private long fileSize;
	private final Object lock = new Object();

	/**
	 * Initialize the {@link DownloadAgent} with which will be downloaded the file.
	 *
	 * @param downloadApp shows the progress of the download
	 */
	public DownloadAgent(DownloadApp downloadApp) {
		this.downloadApp = downloadApp;
		this.fileSize = 0;
	}

	/**
	 * Get the size of the file.
	 *
	 * @return the size of the file
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * Download file.
	 *
	 * @param url from which to download the file
	 */
	public void downloadFile(String url) {
		TransferObject transferator = null;
		try {
			UrlValidator urlValidator = new UrlValidator();
			if (!urlValidator.isValid(url) && !url.startsWith("file:")) {
				downloadApp.setDownloadStatus(false);
				return;
			}
			URLConnection connection = getConnection(url);
			fileSize = connection.getContentLengthLong();
			downloadApp.setFileSize(fileSize);
			transferator = new TransferObject(getInputStream(connection),
					getOutputStream(downloadApp.getFile()));
			downloadApp.setDownloadButtonInactive();
			TransferObject finalTransferator = transferator;
			Thread thread = new Thread(() -> {
				int read = 0;
				long downloaded = 0;
				int percentProgress = 0;
				while (read != -1) {

					downloaded += read;
					read = finalTransferator.transfer(10000, 0);

					percentProgress = ((int) (100 * downloaded / fileSize));
					downloadApp.setProgress(percentProgress);

					downloadApp.setDownloadedSize(downloaded);
				}
				downloadApp.setDownloadStatus(true);
				downloadApp.setDownloadButtonActive();
				downloadApp.emptyTextArea();
			});
			thread.start();

		} catch (IOException e) {
			downloadApp.setDownloadStatus(false);
		}
	}

	/**
	 * Get connection.
	 */
	private URLConnection getConnection(String url) throws IOException {
		return new URL(url).openConnection();
	}

	/**
	 * Get input stream.
	 */
	private InputStream getInputStream(URLConnection connection)
			throws IOException {
		return connection.getInputStream();
	}

	/**
	 * Get output stream.
	 */
	private OutputStream getOutputStream(File file)
			throws FileNotFoundException {
		return new BufferedOutputStream(new FileOutputStream(file));
	}
}