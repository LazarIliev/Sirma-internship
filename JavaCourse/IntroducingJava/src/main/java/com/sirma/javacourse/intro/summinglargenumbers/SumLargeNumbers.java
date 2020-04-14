package com.sirma.javacourse.intro.summinglargenumbers;

/**
 * This class has a method which is summing two large numbers properly but they are recorded like strings.
 */
class SumLargeNumbers {

	private static int carry = 0;

	SumLargeNumbers() {
	}

	/**
	 * This method is accepting two strings with large numbers. It is checking if the first string is with bigger length
	 * so if it is to swap them. Reverse both strings and keep adding digits one by one from 0 index (in empty StringBuilder)
	 * to end of smaller string, append the sum % 10 to end of result and keep track of carry as sum/10.
	 *
	 * @param numOneAsString string value of the first number.
	 * @param numTwoAsString string value of the second number.
	 * @return string value of the sum of both numbers.
	 */
	static String sum(String numOneAsString, String numTwoAsString) {
		if (numOneAsString.length() > numTwoAsString.length()) {
			String temp = numOneAsString;
			numOneAsString = numTwoAsString;
			numTwoAsString = temp;
		}

		StringBuilder sb = new StringBuilder();

		char[] charFirstReversed = new StringBuilder(numOneAsString).reverse().toString().toCharArray();
		char[] charSecondReversed = new StringBuilder(numTwoAsString).reverse().toString().toCharArray();

		for (int i = 0; i < charFirstReversed.length; i++) {
			int numFromFirst = Character.getNumericValue(charFirstReversed[i]);
			int numFromSecond = Character.getNumericValue(charSecondReversed[i]);

			int sumCurrent = numFromFirst + numFromSecond;

			sumCurrent = checkForCarry(sumCurrent);

			sb.append(sumCurrent);
		}

		for (int i = numOneAsString.length(); i < numTwoAsString.length(); i++) {
			int num = Character.getNumericValue(charSecondReversed[i]);

			num = checkForCarry(num);

			sb.append(num);
		}
		return sb.reverse().toString();
	}

	private static int checkForCarry(int sum) {
		if (carry > 0) {
			sum++;
			carry--;
		}

		if (sum >= 10) {
			sum -= 10;
			carry++;
		}
		return sum;
	}
}
