package com.godoro.jpareal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Complex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long complexId;
    private String complexName;
    private double complexValue;
    @Enumerated(value = EnumType.STRING)
    private ComplexKind complexKind;

    @Temporal(TemporalType.DATE)
    private Date complexDate;

    @Transient //DATABASE'DE TUTMA DEMEK
    private String temporaryField;

    public long getComplexId() {
        return complexId;
    }

    public void setComplexId(long complexId) {
        this.complexId = complexId;
    }

    public Date getComplexDate() {
        return complexDate;
    }

    public void setComplexDate(Date complexDate) {
        this.complexDate = complexDate;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public double getComplexValue() {
        return complexValue;
    }

    public void setComplexValue(double complexValue) {
        this.complexValue = complexValue;
    }

    public ComplexKind getComplexKind() {
        return complexKind;
    }

    public void setComplexKind(ComplexKind complexKind) {
        this.complexKind = complexKind;
    }

    public String getTemporaryField() {
        return temporaryField;
    }

    public void setTemporaryField(String temporaryField) {
        this.temporaryField = temporaryField;
    }
    
}
