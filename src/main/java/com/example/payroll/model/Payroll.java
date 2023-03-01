package com.example.payroll.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("payroll")
public class Payroll {

	@Id
	private int employeeId;
	private int payrollId;
	private String registeredBank;
	private long bankAccountNumber;
	private long monthlySalary;

	public Payroll() {

	}

	public Payroll(int employeeId, int payrollId, String registeredBank, long bankAccountNumber, int monthlySalary) {
		super();
		this.employeeId = employeeId;
		this.payrollId = payrollId;
		this.registeredBank = registeredBank;
		this.bankAccountNumber = bankAccountNumber;
		this.monthlySalary = monthlySalary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public String getRegisteredBank() {
		return registeredBank;
	}

	public void setRegisteredBank(String registeredBank) {
		this.registeredBank = registeredBank;
	}

	public long getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(long bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public long getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(long monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Override
	public String toString() {
		return "Payroll [employeeId=" + employeeId + ", payrollId=" + payrollId + ", registeredBank=" + registeredBank
				+ ", bankAccountNumber=" + bankAccountNumber + ", monthlySalary=" + monthlySalary + "]";
	}

}