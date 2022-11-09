package com.godoro.composite.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity @IdClass(DirectorId.class)
public class Director {
    @Id
    private long employeeId;
    @Id
    private long projectId;
    private String directoryTitle;

    public Director() {
    }

    public Director(long employeeId, long projectId, String directoryTitle) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.directoryTitle = directoryTitle;
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

    public String getDirectoryTitle() {
        return this.directoryTitle;
    }

    public void setDirectoryTitle(String directoryTitle) {
        this.directoryTitle = directoryTitle;
    }

    public Director employeeId(long employeeId) {
        setEmployeeId(employeeId);
        return this;
    }

    public Director projectId(long projectId) {
        setProjectId(projectId);
        return this;
    }

    public Director directoryTitle(String directoryTitle) {
        setDirectoryTitle(directoryTitle);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Director)) {
            return false;
        }
        Director director = (Director) o;
        return employeeId == director.employeeId && projectId == director.projectId && Objects.equals(directoryTitle, director.directoryTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, projectId, directoryTitle);
    }

    @Override
    public String toString() {
        return "{" +
            " employeeId='" + getEmployeeId() + "'" +
            ", projectId='" + getProjectId() + "'" +
            ", directoryTitle='" + getDirectoryTitle() + "'" +
            "}";
    }

}
