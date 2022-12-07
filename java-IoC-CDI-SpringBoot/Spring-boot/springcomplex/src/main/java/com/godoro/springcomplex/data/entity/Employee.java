package com.godoro.springcomplex.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	private String employeeName;
	private double monthlySalary;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Employee() {
	}

	public Employee(long employeeId, String employeeName, double monthlySalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.monthlySalary = monthlySalary;
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getMonthlySalary() {
		return this.monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return "{" + " employeeId='" + getEmployeeId() + "'" + ", employeeName='" + getEmployeeName() + "'"
				+ ", monthlySalary='" + getMonthlySalary() + "'" + "}";
	}

}
