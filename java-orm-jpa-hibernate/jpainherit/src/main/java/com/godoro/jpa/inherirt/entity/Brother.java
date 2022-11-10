package com.godoro.jpa.inherirt.entity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BROTHER")
public class Brother extends Parent {

    private boolean brotherCheck;

    public Brother() {
    }

    public Brother(long entityId, String entityName, double entityValue, boolean brotherCheck) {
        super(entityId, entityName, entityValue);
        this.brotherCheck = brotherCheck;
    }

    public boolean isBrotherCheck() {
        return this.brotherCheck;
    }

    public boolean getBrotherCheck() {
        return this.brotherCheck;
    }

    public void setBrotherCheck(boolean brotherCheck) {
        this.brotherCheck = brotherCheck;
    }

    public Brother brotherCheck(boolean brotherCheck) {
        setBrotherCheck(brotherCheck);
        return this;
    }

    @Override
    public String toString() {
        return "{" + super.toString() + "'" +
                ", brotherCheck='" + isBrotherCheck() + "'" +
                "}";
    }

}
