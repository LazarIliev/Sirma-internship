package com.sirma.javacourse.numbersconsole;

/**
 * Custom Exception class for numbers not in a specific interval.
 */
 class NumberNotInIntervalException extends RuntimeException{
	public NumberNotInIntervalException(){
		super();
	}

	NumberNotInIntervalException(String errorMessage){
		super(errorMessage);
	}
}
