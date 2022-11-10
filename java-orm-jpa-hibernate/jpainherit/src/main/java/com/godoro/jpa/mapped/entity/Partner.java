package com.godoro.jpa.mapped.entity;

import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass   
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long parentId;
    private String parentName;

    public Partner() {
    }

    public Partner(long parentId, String parentName) {
        this.parentId = parentId;
        this.parentName = parentName;
    }

    public long getParentId() {
        return this.parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Partner parentId(long parentId) {
        setParentId(parentId);
        return this;
    }

    public Partner parentName(String parentName) {
        setParentName(parentName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Partner)) {
            return false;
        }
        Partner parent = (Partner) o;
        return parentId == parent.parentId && Objects.equals(parentName, parent.parentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentId, parentName);
    }

    @Override
    public String toString() {
        return "Partner [parentId=" + parentId + ", parentName=" + parentName + "]";
    }

    

}
