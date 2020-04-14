package com.sirma.javacourse.objects.sumator;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumatorTest {

	private Sumator sumator = new Sumator();

	@Test
	void testSum_withIntegerInput_shouldWorkCorrect() {
		int a = 2000000;
		int b = 5000000;

		int expectedSum = sumator.sum(a, b);
		int actualSum = 7000000;

		Assertions.assertEquals(expectedSum, actualSum);
	}

	@Test
	void testSum_withFloatInput_shouldWorkCorrect() {
		float a = 20000.4F;
		float b = 50000.4F;

		float expectedSum = sumator.sum(a, b);
		float actualSum = 70000.8F;

		Assertions.assertEquals(expectedSum, actualSum);
	}

	@Test
	void testSum_withDoubleInput_shouldWorkCorrect() {
		double a = 200000.4;
		double b = 500000.4;

		double expectedSum = sumator.sum(a, b);
		double actualSum = 700000.8;

		Assertions.assertEquals(expectedSum, actualSum);
	}

	@Test
	void testSum_withBigIntegerInput_shouldWorkCorrect() {
		BigInteger a = new BigInteger("20844444");
		BigInteger b = new BigInteger("2084443333");

		BigInteger expectedSum = sumator.sum(a, b);
		BigInteger actualSum = new BigInteger("2105287777");

		Assertions.assertEquals(expectedSum, actualSum);
	}

	@Test
	void testSum_withBigDecimal_shouldWorkCorrect() {
		BigDecimal a = new BigDecimal("546464747472");
		BigDecimal b = new BigDecimal("546464747472");

		BigDecimal expectedSum = sumator.sum(a, b);
		BigDecimal actualSum = new BigDecimal("1092929494944");

		Assertions.assertEquals(expectedSum, actualSum);
	}

	@Test
	void testSum_withStringInput_shouldWorkCorrect() {
		String a = "5";
		String b = "10";

		String expectedSum = sumator.sum(a, b);
		String actualSum = "15";

		Assertions.assertEquals(expectedSum, actualSum);
	}
}