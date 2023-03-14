package com.filehandling;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ToProvideEmployeePayrollServices {

	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	private List<ToAddEmployeePayrollInfo> employeePayrollList;

	public ToProvideEmployeePayrollServices() {
	}

	public ToProvideEmployeePayrollServices(List<ToAddEmployeePayrollInfo> employeePayrollList) {
		this.employeePayrollList = employeePayrollList;
	}

	private void readEmployeePayrollData(Scanner consoleInputReader) {

		System.out.println("Enter the Employee Id : ");
		int id = consoleInputReader.nextInt();
		System.out.println("Enter the Employee Name : ");
		String name = consoleInputReader.next();
		System.out.println("Enter the Employee Salary : ");
		double salary = consoleInputReader.nextDouble();

		employeePayrollList.add(new ToAddEmployeePayrollInfo(id, name, salary));
	}

	public void writeEmployeePayrollData(IOService ioService) {
		if(ioService.equals(IOService.CONSOLE_IO))
			System.out.println("\nWriting Employee Payroll Roster to Console\n" + employeePayrollList);

		else if(ioService.equals(IOService.FILE_IO))
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
	}

	public void printData(IOService fileIo) {
		if(fileIo.equals(IOService.FILE_IO)) new EmployeePayrollFileIOService().printData();
	}


	public long countEntries(IOService fileIo) {
		if(fileIo.equals(IOService.FILE_IO))
			return new EmployeePayrollFileIOService().countEntries();

		return 0;
	}


	public long readDataFromFile(IOService fileIo) {

		List<String> employeePayrollFromFile = new ArrayList<String>();
		if(fileIo.equals(IOService.FILE_IO)) {
			System.out.println("Employee Details from payroll-file.txt");
			employeePayrollFromFile = new EmployeePayrollFileIOService().readDataFromFile();

		}
		return employeePayrollFromFile.size();
	}

	public static void main(String[] args) {

		System.out.println("---------- Welcome To Employee Payroll Application ----------\n");
		ArrayList<ToAddEmployeePayrollInfo> employeePayrollList  = new ArrayList<ToAddEmployeePayrollInfo>();
		ToProvideEmployeePayrollServices employeePayrollService = new ToProvideEmployeePayrollServices(employeePayrollList);
		Scanner consoleInputReader = new Scanner(System.in);

		employeePayrollService.readEmployeePayrollData(consoleInputReader);
		employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
	}



}