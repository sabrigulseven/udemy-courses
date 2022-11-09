package com.godoro.composite.entity;

import java.io.Serializable;

public class DirectorId implements Serializable {
    private long employeeId;
    private long projectId;

    public DirectorId() {
    }

    public DirectorId(long employeeId, long projectId) {
        this.employeeId = employeeId;
        this.projectId = projectId;
    }

    public long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "{" +
                " employeeId='" + getEmployeeId() + "'" +
                ", projectId='" + getProjectId() + "'" +
                "}";
    }
}
