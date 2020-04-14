package com.sirma.javacourse.objects.supermarket;

/**
 * Interface for all employees and their public methods.
 * 
 */
public interface Employee {
	int getEmployeeID();
	
	void work();
	
	Departments getEmployeeDepartment();
}
