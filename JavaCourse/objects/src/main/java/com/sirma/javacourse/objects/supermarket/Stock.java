package com.sirma.javacourse.objects.supermarket;

import java.math.BigDecimal;

public interface Stock {
	int getProductID();
	
	String getProductName();
	
	String getDescription();
	
	BigDecimal getPrice();
	
	int getAmount();
	
	void setAmount(int amount);
}
