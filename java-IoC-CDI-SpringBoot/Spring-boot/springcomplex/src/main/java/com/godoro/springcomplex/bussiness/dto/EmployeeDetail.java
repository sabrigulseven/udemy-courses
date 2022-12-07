package com.godoro.springcomplexbussiness.dto;

public class EmployeeDetail {

	private long employeeId;

	private String employeeName;

	private double monthlySalary;

	private long departmentId;

	private String departmentName;

	public EmployeeDetail() {
	}

	public EmployeeDetail(long employeeId, String employeeName, double monthlySalary, long departmentId,
			String departmentName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.monthlySalary = monthlySalary;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
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

	public long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "{" +
				" employeeId='" + getEmployeeId() + "'" +
				", employeeName='" + getEmployeeName() + "'" +
				", monthlySalary='" + getMonthlySalary() + "'" +
				", departmentId='" + getDepartmentId() + "'" +
				", departmentName='" + getDepartmentName() + "'" +
				"}";
	}

}
