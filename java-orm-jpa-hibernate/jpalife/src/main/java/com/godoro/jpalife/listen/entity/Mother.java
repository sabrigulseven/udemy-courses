package com.godoro.jpalife.listen.entity;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
@EntityListeners({ HeritageListener.class })
public class Mother {
    private String nameField;

    @PrePersist
    public void onPrePersist() {
        System.out.println("Direme öncesi...");
    }

    public String getNameField() {
        return nameField;
    }

    public void setNameField(String nameField) {
        this.nameField = nameField;
    }

}
