package com.godoro.springcomplex.bussiness.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.godoro.springcomplex.bussiness.dto.DepartmentDetail;
import com.godoro.springcomplex.bussiness.dto.DepartmentSummary;
import com.godoro.springcomplex.bussiness.service.DepartmentService;
import com.godoro.springcomplex.data.entity.Department;
import com.godoro.springcomplex.data.entity.Employee;
import com.godoro.springcomplex.data.repositoy.DepartmentRepository;
import com.godoro.springcomplex.data.repositoy.EmployeeRepositoy;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private EmployeeRepositoy employeeRepositoy;

	@Override
	public DepartmentSummary list() {
		DepartmentSummary departmentSummary = new DepartmentSummary();
		departmentSummary.setDepartmentDetailList(new ArrayList<>());
		for (Department department : departmentRepository.findAll()) {
			DepartmentDetail departmentDetail = toDto(department);
			departmentSummary.getDepartmentDetailList().add(departmentDetail);
		}
		return departmentSummary;
	}

	private DepartmentDetail toDto(Department department) {
		DepartmentDetail departmentDetail = new DepartmentDetail();
		departmentDetail.setDepartmentId(department.getDepartmentId());
		departmentDetail.setDepartmentName(department.getDepartmentName());
		return departmentDetail;
	}

	@Transactional
	@Override
	public long generateDepartment(String departmentName) {
		Department department = new Department(0, departmentName);
		departmentRepository.save(department);
		generateEmployees(department);
		return department.getDepartmentId();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	private void generateEmployees(Department department) {
		Employee employee1 = new Employee();
		employee1.setEmployeeName("Sekreter");
		employee1.setMonthlySalary(4211);
		employee1.setDepartment(department);
		employeeRepositoy.save(employee1);

		Employee employee2 = new Employee();
		employee2.setEmployeeName("Şöför");
		employee2.setMonthlySalary(3211);
		employee2.setDepartment(department);
		employeeRepositoy.save(employee2);

		if (employee2.getMonthlySalary() > 1) {
			throw new RuntimeException();

		}
		Employee employee3 = new Employee();
		employee3.setEmployeeName("Çaycı");
		employee3.setMonthlySalary(2211);
		employee3.setDepartment(department);
		employeeRepositoy.save(employee3);
	}

}
