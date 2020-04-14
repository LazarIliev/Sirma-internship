package com.sirma.javacourse.designpatterns.proxy;

/**
 * Runner class for proxy pattern.
 */
public class RunnerProxy {
	public static void main(String[] args) {
		Number number = IntegerFactory.createInstance();
		number.setNumber(5);
		int num = number.getNumber();
	}
}
