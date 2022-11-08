package com.godoro.jpareal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "cust")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private long customerId;

    @Column(name = "cust_name")
    private String customerName;

    @Column(name = "tot_deb")
    private double totalDebit;

    public long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public double getTotalDebit() {
        return totalDebit;
    }
    public void setTotalDebit(double totalDebit) {
        this.totalDebit = totalDebit;
    }
    public Customer(long customerId, String customerName, double totalDebit) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalDebit = totalDebit;
    }
    public Customer() {
    }
    
}
