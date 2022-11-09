package com.godoro.composite.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;
    private String taskName;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "projectIdParticipant", referencedColumnName = "projectId"),
            @JoinColumn(name = "employeeIdParticipant", referencedColumnName = "employeeId"),
    })
    private Participant participant;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "projectIdDirector", referencedColumnName = "projectId"),
            @JoinColumn(name = "employeeIdDirector", referencedColumnName = "employeeId"),
    })
    private Director director;

    public Task() {
    }

    public Task(long taskId, String taskName, Participant participant, Director director) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.participant = participant;
        this.director = director;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Participant getParticipant() {
        return this.participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Director getDirector() {
        return this.director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Task taskId(long taskId) {
        setTaskId(taskId);
        return this;
    }

    public Task taskName(String taskName) {
        setTaskName(taskName);
        return this;
    }

    public Task participant(Participant participant) {
        setParticipant(participant);
        return this;
    }

    public Task director(Director director) {
        setDirector(director);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return taskId == task.taskId && Objects.equals(taskName, task.taskName)
                && Objects.equals(participant, task.participant) && Objects.equals(director, task.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, taskName, participant, director);
    }

    @Override
    public String toString() {
        return "{" +
                " taskId='" + getTaskId() + "'" +
                ", taskName='" + getTaskName() + "'" +
                ", participant='" + getParticipant() + "'" +
                ", director='" + getDirector() + "'" +
                "}";
    }

}
