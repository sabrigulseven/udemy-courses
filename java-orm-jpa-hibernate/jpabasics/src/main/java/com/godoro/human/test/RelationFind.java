package com.godoro.human.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.human.entity.Department;
import com.godoro.human.entity.Employee;

public class RelationFind {
    public static void main(String[] args) {
        long departmentId = 1;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Department department = entityManager.find(Department.class, departmentId); 

        entityManager.close();
        
        System.out.println(department.getDepartmentId()+" "+ department.getDepartmentName());
        
        for (Employee employee : department.getEmployeeList()) {
            System.out.println("\t"+employee.getEmployeeId()+" "+employee.getEmployeeName()+" "+employee.getMonthlySalary());
        }

        

    }
}
