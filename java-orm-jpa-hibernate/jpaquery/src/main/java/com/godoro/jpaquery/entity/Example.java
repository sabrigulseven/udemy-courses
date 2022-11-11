package com.godoro.jpaquery.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    
    @NamedQuery(
    name = "Example.findAll", 
    query = "Select example from Example as example" ),
    
    @NamedQuery(
    name = "Example.findAllMin", 
    query = "Select example from Example as example where example.exampleValue > :exampleValueMin")
})

public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exampleId;
    private String exampleName;
    private double exampleValue;

    public Example() {
    }

    public Example(long exampleId, String exampleName, double exampleValue) {
        this.exampleId = exampleId;
        this.exampleName = exampleName;
        this.exampleValue = exampleValue;
    }

    public long getExampleId() {
        return this.exampleId;
    }

    public void setExampleId(long exampleId) {
        this.exampleId = exampleId;
    }

    public String getExampleName() {
        return this.exampleName;
    }

    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }

    public double getExampleValue() {
        return this.exampleValue;
    }

    public void setExampleValue(double exampleValue) {
        this.exampleValue = exampleValue;
    }

    public Example exampleId(long exampleId) {
        setExampleId(exampleId);
        return this;
    }

    public Example exampleName(String exampleName) {
        setExampleName(exampleName);
        return this;
    }

    public Example exampleValue(double exampleValue) {
        setExampleValue(exampleValue);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Example)) {
            return false;
        }
        Example example = (Example) o;
        return exampleId == example.exampleId && Objects.equals(exampleName, example.exampleName)
                && exampleValue == example.exampleValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exampleId, exampleName, exampleValue);
    }

    @Override
    public String toString() {
        return "{" +
                " exampleId='" + getExampleId() + "'" +
                ", exampleName='" + getExampleName() + "'" +
                ", exampleValue='" + getExampleValue() + "'" +
                "}";
    }

}
