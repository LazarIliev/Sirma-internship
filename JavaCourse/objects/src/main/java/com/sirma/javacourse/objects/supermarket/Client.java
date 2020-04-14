package com.sirma.javacourse.objects.supermarket;
public class Client extends Person {
	private static int clientID = 0;

	public Client(String name, int age) {
		super(name, age);
		Client.clientID++;
	}
	
	public int getClientID() {
		return clientID;
	}
}
