package com.godoro.jpalife.cache.entity;

import java.util.Objects;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Cacheable(true)
public class Frequent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long frequentId;
    private String frequentName;

    public Frequent() {
    }

    public Frequent(long frequentId, String frequentName) {
        this.frequentId = frequentId;
        this.frequentName = frequentName;
    }

    public long getFrequentId() {
        return this.frequentId;
    }

    public void setFrequentId(long frequentId) {
        this.frequentId = frequentId;
    }

    public String getFrequentName() {
        return this.frequentName;
    }

    public void setFrequentName(String frequentName) {
        this.frequentName = frequentName;
    }

    public Frequent frequentId(long frequentId) {
        setFrequentId(frequentId);
        return this;
    }

    public Frequent frequentName(String frequentName) {
        setFrequentName(frequentName);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Frequent)) {
            return false;
        }
        Frequent frequent = (Frequent) o;
        return frequentId == frequent.frequentId && Objects.equals(frequentName, frequent.frequentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequentId, frequentName);
    }

}
