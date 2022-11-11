package com.godoro.jpaquery.criteria.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.godoro.jpaquery.entity.Department;
import com.godoro.jpaquery.entity.Employee;

public class CriteriaRelation {
    public static void main(String[] args) {
        double monthlySalaryMax = 5000;
        String departmentNamePattern ="%at%";
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        Join<Employee,Department> relation = root.join(("department"));
        Predicate conditionSalary = builder.lt(root.<Double>get("monthlySalary"), monthlySalaryMax);
        Predicate conditionDepartment = builder.like(relation.get("departmentName"), departmentNamePattern);
        Predicate condition = builder.and(conditionDepartment, conditionSalary);
        criteria.where(condition);
        TypedQuery<Employee> query = entityManager.createQuery(criteria);
        List<Employee> employeeList = query.getResultList();

        for (Employee e : employeeList) {
            System.out.println(e.getEmployeeId() + " "
                    + e.getEmployeeName() + " "
                    + e.getMonthlySalary());
        }
    }
}
