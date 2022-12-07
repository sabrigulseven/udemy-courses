package com.godoro.springcomplex.data.repositoy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.godoro.springcomplex.data.entity.Department;
import com.godoro.springcomplex.data.entity.Employee;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
