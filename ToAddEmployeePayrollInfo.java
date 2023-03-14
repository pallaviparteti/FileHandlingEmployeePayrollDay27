package com.filehandling;

public class ToAddEmployeePayrollInfo {
	int employeeId;
	String employeeName;
	double employeeSalary;

	public ToAddEmployeePayrollInfo(Integer id, String name, Double salary) {

		this.employeeId = id;
		this.employeeName = name;
		this.employeeSalary = salary;
	}

	@Override
	public String toString() {

		return "EmployeeId: "+employeeId+", EmployeeName: "+employeeName+", EmployeeSalary: "+employeeSalary;
	}
}