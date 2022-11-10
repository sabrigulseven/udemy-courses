package com.godoro.jpalife.lock.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpalife.lock.entity.Shared;

public class LockTrier {
    public static void main(String[] args) {
        long sharedtId = 1;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();
        long time = 0;
        long timeout = 20000;
        while (time < timeout) {

            try {
                Shared shared = entityManager.find(Shared.class, sharedtId);
                System.out.println(time+" "+shared.getSharedName());

                entityManager.getTransaction().begin();

                shared.setSharedName("Üleşilen Ad 4");

                entityManager.merge(shared);

                entityManager.getTransaction().commit();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        entityManager.close();

    }
}
