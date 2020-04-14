package com.sirma.javacourse.chatclient.models;

public class LoginInputModel {
	private String nickname;
	private String ipAddress;
	private String portString;


	public LoginInputModel() {
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getPortString() {
		return portString;
	}

	public void setPortString(String portString) {
		this.portString = portString;
	}
}
