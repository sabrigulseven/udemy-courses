package com.godoro.jpa.inherirt.entity;

import java.util.Objects;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SIBLING_TYPE")
public abstract class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long entityId;
    private String entityName;
    private double entityValue;

    public Parent() {
    }

    public Parent(long entityId,String entityName, double entityValue) {
        this.entityId = entityId;
        this.entityName = entityName;
        this.entityValue = entityValue;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public long getEntityId() {
        return this.entityId;
    }

    public void setEntityId(long entityId) {
        this.entityId = entityId;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public double getEntityValue() {
        return this.entityValue;
    }

    public void setEntityValue(double entityValue) {
        this.entityValue = entityValue;
    }

    public Parent entityName(String entityName) {
        setEntityName(entityName);
        return this;
    }

    public Parent entityValue(double entityValue) {
        setEntityValue(entityValue);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Parent)) {
            return false;
        }
        Parent parent = (Parent) o;
        return Objects.equals(entityName, parent.entityName) && entityValue == parent.entityValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entityName, entityValue);
    }

    @Override
    public String toString() {
        return "{" +
            " entityName='" + getEntityName() + "'" +
            ", entityValue='" + getEntityValue() + "'" +
            "}";
    }

}
