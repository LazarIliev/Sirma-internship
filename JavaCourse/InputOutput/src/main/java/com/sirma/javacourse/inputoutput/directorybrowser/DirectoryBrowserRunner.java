package com.sirma.javacourse.inputoutput.directorybrowser;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for DirectoryBrowser's method listContent.
 */
public class DirectoryBrowserRunner {
	private static final Logger logger = LoggerFactory.getLogger(DirectoryBrowserRunner.class);

	public static void main(String[] args)  {
		try {
			URI resource = DirectoryBrowserRunner.class.getResource("/change.txt").toURI();
			Path pa = Paths.get(resource);
			String content = DirectoryBrowser.listContent(pa);
			logger.info(content);
		}catch (URISyntaxException e){
			logger.info(e.getMessage(), e);
		}
	}
}
