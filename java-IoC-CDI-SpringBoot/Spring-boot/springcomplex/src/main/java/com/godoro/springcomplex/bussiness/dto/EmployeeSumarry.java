package com.godoro.springcomplexbussiness.dto;

import java.util.List;

public class EmployeeSumary {
	private int employeeCount;
	private long departmentId;
	private String departmentName;
	private List<EmployeeDetail> employeeDetailList;

	public List<EmployeeDetail> getEmployeeDetailList() {
		return employeeDetailList;
	}

	public void setEmployeeDetailList(List<EmployeeDetail> employeeDetailList) {
		this.employeeDetailList = employeeDetailList;
	}

	public int getEmployeeCount() {
		return this.employeeCount;
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
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

}
