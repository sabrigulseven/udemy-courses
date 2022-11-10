package com.godoro.jpalife.listen.entity;

import javax.persistence.PostPersist;

public class LivingListener {

    @PostPersist
    public void onPostPersist(Living living) {
        System.out.println("Varlık direliyor.. "+living);
    }
}
