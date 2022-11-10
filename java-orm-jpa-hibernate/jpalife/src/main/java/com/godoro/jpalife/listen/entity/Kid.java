package com.godoro.jpalife.listen.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kid extends Mother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idField;

    public Kid() {
    }

    public Kid(long idField) {
        this.idField = idField;
    }

    public long getIdField() {
        return this.idField;
    }

    public void setIdField(long idField) {
        this.idField = idField;
    }

    public Kid idField(long idField) {
        setIdField(idField);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Kid)) {
            return false;
        }
        Kid kid = (Kid) o;
        return idField == kid.idField;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idField);
    }

    @Override
    public String toString() {
        return "{" +
                " idField='" + getIdField() + "'" +
                "}";
    }
}
