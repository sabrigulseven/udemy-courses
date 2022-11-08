package com.godoro.jpareal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Big {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bigId;
    @Lob
    private String bigText;
    @Lob
    private byte[] bigBytes;

    public long getBigId() {
        return bigId;
    }

    public void setBigId(long bigId) {
        this.bigId = bigId;
    }

    public String getBigText() {
        return bigText;
    }

    public void setBigText(String bigText) {
        this.bigText = bigText;
    }

    public byte[] getBigBytes() {
        return bigBytes;
    }

    public void setBigBytes(byte[] bigBytes) {
        this.bigBytes = bigBytes;
    }

}
