package com.godoro.composite.entity;

import java.io.Serializable;

public class ParticipantId implements Serializable{
    private long employeeId;
    private long projectId;

    public ParticipantId() {
    }

    public ParticipantId(long employeeId, long projectId) {
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

    public ParticipantId employeeId(long employeeId) {
        setEmployeeId(employeeId);
        return this;
    }

    public ParticipantId projectId(long projectId) {
        setProjectId(projectId);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " employeeId='" + getEmployeeId() + "'" +
                ", projectId='" + getProjectId() + "'" +
                "}";
    }

}
