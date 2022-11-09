package com.godoro.composite.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String employeeName;

    public Employee() {
    }

    public Employee(long employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Employee employeeId(long employeeId) {
        setEmployeeId(employeeId);
        return this;
    }

    public Employee employeeName(String employeeName) {
        setEmployeeName(employeeName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId && Objects.equals(employeeName, employee.employeeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeName);
    }

    @Override
    public String toString() {
        return "{" +
            " employeeId='" + getEmployeeId() + "'" +
            ", employeeName='" + getEmployeeName() + "'" +
            "}";
    }

}
