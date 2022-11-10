package com.godoro.jpa.inherirt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SISTER")
public class Sister extends Parent {

    private short sisterCode;

    public Sister() {
    }

    public Sister(long entityId, String entityName, double entityValue, short sisterCode) {
        super(entityId, entityName, entityValue);
        this.sisterCode = sisterCode;
    }

    public short getSisterCode() {
        return this.sisterCode;
    }

    public void setSisterCode(short sisterCode) {
        this.sisterCode = sisterCode;
    }

    @Override
    public String toString() {
        return "Sister ["+super.toString()+" sisterCode=" + sisterCode + "]";
    }
    
}
