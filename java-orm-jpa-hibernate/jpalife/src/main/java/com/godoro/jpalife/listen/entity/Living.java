package com.godoro.jpalife.listen.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Living {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long livingId;
    private String firstName;
    private String lastName;
    private boolean emptyName;

    public Living() {
    }

    public Living(long livingId, String firstName, String lastName, boolean emptyName) {
        this.livingId = livingId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emptyName = emptyName;
    }

    public long getLivingId() {
        return this.livingId;
    }

    public void setLivingId(long livingId) {
        this.livingId = livingId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEmptyName() {
        return this.emptyName;
    }

    public boolean getEmptyName() {
        return this.emptyName;
    }

    public void setEmptyName(boolean emptyName) {
        this.emptyName = emptyName;
    }

    public Living livingId(long livingId) {
        setLivingId(livingId);
        return this;
    }

    public Living firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Living lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Living emptyName(boolean emptyName) {
        setEmptyName(emptyName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Living)) {
            return false;
        }
        Living living = (Living) o;
        return livingId == living.livingId && Objects.equals(firstName, living.firstName)
                && Objects.equals(lastName, living.lastName) && emptyName == living.emptyName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(livingId, firstName, lastName, emptyName);
    }

    @Override
    public String toString() {
        return "{" +
                " livingId='" + getLivingId() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", emptyName='" + isEmptyName() + "'" +
                "}";
    }

    @PrePersist
    public void onPrePersist() {
        if (firstName == null || firstName.equals("") || lastName == null || lastName.equals("")) {
            emptyName = true;
        }
    }
}
