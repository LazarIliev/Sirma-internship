package com.sirma.javacourse.javagui.transmitter;

/**
 * Holds constants for the multi-cast server-client application.
 */
public interface MulticastingElements {
	int MULTICAST_PORT = 7000;
	int SMALL_SIZE_BUFFER = 256;
	int MIDDLE_SIZE_BUFFER = 1024;
	int BIG_SIZE_BUFFER = 4096;
	String STRING_CHANNEL_IP = "230.0.0.1";
	String INTEGER_CHANNEL_IP = "229.0.0.1";
	String INTEGER_CHANNEL_NAME = "Integer";
	String STRING_CHANNEL_NAME = "String";
	String END_OF_SERVER = "end";
}
