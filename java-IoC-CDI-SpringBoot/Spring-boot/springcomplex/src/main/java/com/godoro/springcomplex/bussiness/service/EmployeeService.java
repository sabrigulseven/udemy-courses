package com.godoro.springcomplex.bussiness.service;

import com.godoro.springcomplex.bussiness.dto.EmployeeDetail;
import com.godoro.springcomplex.bussiness.dto.EmployeeSummary;

public interface EmployeeService {

	public void save(EmployeeDetail employeeDetail);

	public void delete(long employeeId);

	public EmployeeDetail find(long employeeId);

	public EmployeeSummary list();

	public EmployeeSummary listByDepartment(long departmentId);

	public int countByDepartment(long departmentId);

}
