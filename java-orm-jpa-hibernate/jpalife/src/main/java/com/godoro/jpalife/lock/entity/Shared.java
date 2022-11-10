package com.godoro.jpalife.lock.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Shared {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sharedtId;
    private String sharedName;

    @Version
    private long versionNumber;

    public Shared() {
    }

    public Shared(long sharedtId, String sharedName) {
        this.sharedtId = sharedtId;
        this.sharedName = sharedName;
    }

    public long getSharedtId() {
        return this.sharedtId;
    }

    public void setSharedtId(long sharedtId) {
        this.sharedtId = sharedtId;
    }

    public String getSharedName() {
        return this.sharedName;
    }

    public void setSharedName(String sharedName) {
        this.sharedName = sharedName;
    }

    public Shared sharedtId(long sharedtId) {
        setSharedtId(sharedtId);
        return this;
    }

    public Shared sharedName(String sharedName) {
        setSharedName(sharedName);
        return this;
    }

    public long getVersionNumber() {
        return this.versionNumber;
    }

    public void setVersionNumber(long versionNumber) {
        this.versionNumber = versionNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Shared)) {
            return false;
        }
        Shared shared = (Shared) o;
        return sharedtId == shared.sharedtId && Objects.equals(sharedName, shared.sharedName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sharedtId, sharedName);
    }

    @Override
    public String toString() {
        return "{" +
                " sharedtId='" + getSharedtId() + "'" +
                ", sharedName='" + getSharedName() + "'" +
                "}";
    }

}
