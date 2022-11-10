package com.godoro.jpa.mapped.entity;

import javax.persistence.Entity;

@Entity
public class Supplier extends Partner {
    private double totalCredit;

    public Supplier() {
    }

    public Supplier(long parentId, String parentName, double totalCredit) {
        super(parentId, parentName);
        this.totalCredit = totalCredit;
    }

    public double getTotalCredit() {
        return this.totalCredit;
    }

    public void setTotalCredit(double totalCredit) {
        this.totalCredit = totalCredit;
    }

}   
