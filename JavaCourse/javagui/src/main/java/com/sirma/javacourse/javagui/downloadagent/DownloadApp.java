package com.sirma.javacourse.javagui.downloadagent;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * Show progress on downloads.
 */
public class DownloadApp extends JFrame implements ActionListener {
	private final JProgressBar downloadProgress = new JProgressBar();
	private final JTextField textField = new JTextField(20);
	private final JButton downloadFile = new JButton("Start Download");
	private final JLabel size = new JLabel("Size");
	private final JLabel downloaded = new JLabel("Downloaded size");
	private final JLabel downloadStatus = new JLabel("Status:");
	private boolean downloadReady = true;

	/**
	 * Creates the view for the user.
	 */
	public DownloadApp() {
		setTitle("Ready for download!!!");
		setSize(new Dimension(400, 500));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel);
		// -----------------------------
		panel.add(textField);
		panel.add(downloadFile);
		panel.add(downloadProgress);
		JLabel percentValue = new JLabel("Progress in percent...");
		panel.add(percentValue);
		panel.add(size);
		panel.add(downloaded);
		panel.add(downloadStatus);
		// ------------------------------
		downloadProgress.setAlignmentX(CENTER_ALIGNMENT);
		downloadProgress.setMinimum(0);
		downloadProgress.setMaximum(100);
		downloadProgress.setValue(0);
		downloadProgress.setMaximumSize(new Dimension(200, 30));
		textField.setAlignmentX(CENTER_ALIGNMENT);
		textField.setMaximumSize(new Dimension(200, 30));
		downloadFile.addActionListener(this);
		downloadFile.setAlignmentX(CENTER_ALIGNMENT);
		downloadFile.setMaximumSize(new Dimension(200, 30));
		percentValue.setAlignmentX(CENTER_ALIGNMENT);
		percentValue.setMaximumSize(new Dimension(200, 30));
		size.setAlignmentX(CENTER_ALIGNMENT);
		size.setMaximumSize(new Dimension(200, 30));
		downloaded.setAlignmentX(CENTER_ALIGNMENT);
		downloaded.setMaximumSize(new Dimension(200, 30));
		downloadStatus.setAlignmentX(CENTER_ALIGNMENT);
		downloadStatus.setMaximumSize(new Dimension(200, 30));
		setVisible(true);
	}

	/**
	 * Triggered when user click start download button.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == downloadFile && downloadReady) {
			downloadReady = false;
			setTitle("Download file .....");
			downloadStatus.setText("Status:");
			downloadProgress.setVisible(true);
			new Thread(() -> { new DownloadAgent(this).downloadFile(textField.getText()); }).start();
		}
	}

	/**
	 * Set progress in percent.
	 */
	public void setProgress(int progress) {
		downloadProgress.setValue(progress);
	}

	/**
	 * Set file size.
	 */
	public void setFileSize(long fileSize) {
		size.setText(String.valueOf(fileSize));
	}

	/**
	 * Prompt user to enter location on file.
	 */
	public File getFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(fileChooser);
		return fileChooser.getSelectedFile();
	}

	/**
	 * Set how much bytes are transferred.
	 */
	public void setDownloadedSize(long downloadedSize) {
		downloaded.setText(String.valueOf(downloadedSize));
	}

	/**
	 * Display what error are occurred during download.
	 */
	public void setDownloadStatus(boolean completed) {
		downloadReady = true;
		setTitle("Ready for download!!!");
		if (completed) {
			downloadStatus.setText("Download completed!!!");
		} else {
			downloadStatus.setText("Download error!!!");
		}
	}

	/**
	 * Set the download button inactive.
	 */
	public void setDownloadButtonInactive(){
		downloadFile.setEnabled(false);
	}

	/**
	 * Set the download button active.
	 */
	public void setDownloadButtonActive(){
		downloadFile.setEnabled(true);
	}

	/**
	 * Set the text area to be empty.
	 */
	public void emptyTextArea(){
		textField.setText("");
	}
}
