package com.godoro.springcomplex.bussiness.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godoro.springcomplex.bussiness.dto.DepartmentDetail;
import com.godoro.springcomplex.bussiness.dto.DepartmentSummary;
import com.godoro.springcomplex.bussiness.service.DepartmentService;
import com.godoro.springcomplex.data.entity.Department;
import com.godoro.springcomplex.data.repositoy.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

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

}
