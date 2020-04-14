package com.sirma.javacourse.chatserver.utils;

public interface ServerConfig {
	int CLIENT_CONNECTIONS_MAX_SIZE = 20;
	int CLIENT_CHAT_MESSAGE_MAX_LENGTH = 200;

	String HOST = "localhost";
	String[] SERVER_PORTS = { "7000", "7001", "7002", "7003", "7004", "7005" };
	String[] AVAILABLE_LANGUAGES = { "English", "Български" };
}
