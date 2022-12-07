package com.godoro.springcomplex.data.repositoy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.godoro.springcomplex.data.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
