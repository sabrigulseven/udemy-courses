package com.godoro.springcomplexbussiness.service;

import com.godoro.springcomplexbussiness.dto.EmployeeDetail;
import com.godoro.springcomplexbussiness.dto.EmployeeSumary;

public interface EmployeeService {
	
	public void create(EmployeeDetail employeeDetail);
	
	public void update(EmployeeDetail employeeDetail);
	
	public void delete(long employeeId);
	
	public EmployeeDetail find(long employeeId);

	public EmployeeSumary list();
	
	public EmployeeSumary listByDepartment(long departmentId);
	
	public int countByDepartment(long departmentId);

}
