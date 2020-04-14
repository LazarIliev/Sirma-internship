package com.sirma.javacourse.javagui.downloadagent;

import javax.swing.SwingUtilities;

/**
 * Runner class for the Download App Agent
 */
public class Runner {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(DownloadApp::new);
	}
}
