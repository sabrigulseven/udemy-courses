package com.godoro.human.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.godoro.human.entity.Employee;

public class RelationQuery {
    public static void main(String[] args) {
        long departmentId = 2;        
        EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

        String jpql = "Select employee from Employee as employee where employee.department.departmentId = :departmentId";
        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
        query.setParameter("departmentId", departmentId);
        List<Employee> employeeList= query.getResultList();

        entityManager.close();

        for (Employee employee : employeeList) {
            System.out.println(employee.getEmployeeId()+" - "
                    +employee.getEmployeeName()+" - "
                    +employee.getMonthlySalary()+" - "
                    +employee.getDepartment().getDepartmentId()+" - "
                    +employee.getDepartment().getDepartmentName());
        }
    }
}
