package com.sirma.javacourse.objects.supermarket;
/**
 * Enums for the different departments.
 * 
 */
public enum Departments {
	Guard(10) ,
	Cashier(20);
	
	
	private int action; 
	  
    // getter method 
    public int getAction() 
    { 
        return this.action; 
    } 
  
    // enum constructor - cannot be public or protected 
    private Departments(int action) 
    { 
        this.action = action; 
    } 
}
