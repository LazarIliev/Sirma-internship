package com.sirma.javacourse.objects.supermarket;
public class Cashier extends Person implements Employee {
	private static int cashierID = 0;
	private Departments department;

	public Cashier(String name, int age, Departments department) {
		super(name, age);
		Cashier.cashierID++;
		this.department = department;
		
	}

	@Override
	public int getEmployeeID() {
		// TODO Auto-generated method stub
		return cashierID;
	}

	@Override
	public void work() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departments getEmployeeDepartment() {
		// TODO Auto-generated method stub
		return department;
	}
}
