package com.godoro.springcomplexbussiness.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godoro.springcomplex.data.entity.Department;
import com.godoro.springcomplex.data.entity.Employee;
import com.godoro.springcomplex.data.repositoy.DepartmentRepository;
import com.godoro.springcomplex.data.repositoy.EmployeeRepositoy;
import com.godoro.springcomplexbussiness.dto.EmployeeDetail;
import com.godoro.springcomplexbussiness.dto.EmployeeSumary;
import com.godoro.springcomplexbussiness.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepositoy employeeRepositoy;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public void create(EmployeeDetail employeeDetail) {

		Employee employee = toEntity(employeeDetail);
		employeeRepositoy.save(employee);
		employee.setEmployeeId(employee.getEmployeeId());

	}

	@Override
	public void update(EmployeeDetail employeeDetail) {
		Employee employee = toEntity(employeeDetail);
		employeeRepositoy.save(employee);
	}

	@Override
	public void delete(long employeeId) {
		employeeRepositoy.deleteById(employeeId);
	}

	@Override
	public EmployeeDetail find(long employeeId) {
		Optional<Employee> employee = employeeRepositoy.findById(employeeId);
		if (employee.isPresent()) {
			EmployeeDetail employeeDetail = toDto(employee.get());
			return employeeDetail;
		}

		return null;

	}

	@Override
	public EmployeeSumary list() {
		EmployeeSumary employeeSumary = new EmployeeSumary();
		for (Employee employee : employeeRepositoy.findAll()) {
			EmployeeDetail employeeDetail = toDto(employee);
			employeeSumary.getEmployeeDetailList().add(employeeDetail);
		}
		return employeeSumary;
	}

	@Override
	public EmployeeSumary listByDepartment(long departmentId) {
		EmployeeSumary employeeSumary = new EmployeeSumary();
		Optional<Department> department = departmentRepository.findById(departmentId);
		if (department.isPresent()) {
			employeeSumary.setDepartmentId(department.get().getDepartmentId());
			employeeSumary.setDepartmentName(department.get().getDepartmentName());
		}
		for (Employee employee : employeeRepositoy.findByDepartment(departmentId)) {
			EmployeeDetail employeeDetail = toDto(employee);
			employeeSumary.getEmployeeDetailList().add(employeeDetail);
		}
		return employeeSumary;

	}

	@Override
	public int countByDepartment(long departmentId) {
		return employeeRepositoy.countByDepartment(departmentId);
	}

	private Employee toEntity(EmployeeDetail employeeDetail) {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDetail.getEmployeeId());
		employee.setEmployeeName(employeeDetail.getEmployeeName());
		employee.setMonthlySalary(employeeDetail.getMonthlySalary());
		if (employeeDetail.getDepartmentId() == 0) {
			Optional<Department> department = departmentRepository.findById(employeeDetail.getDepartmentId());
			if (department.isPresent()) {
				employee.setDepartment(department.get());
			}
		}

		return employee;
	}

	private EmployeeDetail toDto(Employee employeee) {
		EmployeeDetail employeeDetail = new EmployeeDetail();
		employeeDetail.setEmployeeId(employeee.getEmployeeId());
		employeeDetail.setEmployeeName(employeee.getEmployeeName());
		employeeDetail.setMonthlySalary(employeee.getMonthlySalary());

		if (employeee.getDepartment() != null) {
			employeeDetail.setDepartmentId(employeee.getDepartment().getDepartmentId());
			employeeDetail.setDepartmentName(employeee.getDepartment().getDepartmentName());
		}

		return employeeDetail;
	}
}
