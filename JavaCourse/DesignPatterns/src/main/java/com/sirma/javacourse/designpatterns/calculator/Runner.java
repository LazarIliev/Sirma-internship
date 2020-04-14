package com.sirma.javacourse.designpatterns.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runner class for Calculator. Reads expressions for evaluating until the exit.
 */
public class Runner {
	private static Logger logger = LoggerFactory.getLogger(Runner.class);

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String expression = "";
			Calculator calculator = new Calculator();
			logger.info("Enter expression: ");
			while (!"exit".equals(expression = reader.readLine())) {
				String result = calculator.calc(expression);
				logger.info("Answer: " + result);
			}
		} catch (IOException e) {
			logger.info(e.getMessage(), e);
		}
	}
}
