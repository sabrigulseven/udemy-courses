package com.godoro.composite.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectId;
    private String projectName;

    public Project() {
    }

    public Project(long projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
    }

    public long getProjectId() {
        return this.projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Project projectId(long projectId) {
        setProjectId(projectId);
        return this;
    }

    public Project projectName(String projectName) {
        setProjectName(projectName);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " projectId='" + getProjectId() + "'" +
            ", projectName='" + getProjectName() + "'" +
            "}";
    }
}
