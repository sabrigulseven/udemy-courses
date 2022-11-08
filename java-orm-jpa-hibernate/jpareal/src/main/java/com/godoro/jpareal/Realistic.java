package com.godoro.jpareal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Realistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long realisticId;

    @Column(length = 80, nullable = false, unique = true, updatable = false)
    private String realisticName;

    @Column(precision = 12,scale = 2)
    private double realisticValue;

    public long getRealisticId() {
        return realisticId;
    }

    public void setRealisticId(long realisticId) {
        this.realisticId = realisticId;
    }

    public String getRealisticName() {
        return realisticName;
    }

    public void setRealisticName(String realisticName) {
        this.realisticName = realisticName;
    }

    public double getRealisticValue() {
        return realisticValue;
    }

    public void setRealisticValue(double realisticValue) {
        this.realisticValue = realisticValue;
    }

    public Realistic() {
    }

    public Realistic(long realisticId, String realisticName, double realisticValue) {
        this.realisticId = realisticId;
        this.realisticName = realisticName;
        this.realisticValue = realisticValue;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (realisticId ^ (realisticId >>> 32));
        result = prime * result + ((realisticName == null) ? 0 : realisticName.hashCode());
        long temp;
        temp = Double.doubleToLongBits(realisticValue);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Realistic other = (Realistic) obj;
        if (realisticId != other.realisticId)
            return false;
        if (realisticName == null) {
            if (other.realisticName != null)
                return false;
        } else if (!realisticName.equals(other.realisticName))
            return false;
        if (Double.doubleToLongBits(realisticValue) != Double.doubleToLongBits(other.realisticValue))
            return false;
        return true;
    }

}
