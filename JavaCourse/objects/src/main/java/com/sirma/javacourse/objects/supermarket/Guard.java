package com.sirma.javacourse.objects.supermarket;
public class Guard extends Person implements Employee {
	private static int guardID = 0;
	private Departments department;
	
	public Guard(String name, int age, Departments department) {
		super(name, age);
		Guard.guardID++;
		this.department = department;
	}

	@Override
	public int getEmployeeID() {
		// TODO Auto-generated method stub
		return guardID;
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
