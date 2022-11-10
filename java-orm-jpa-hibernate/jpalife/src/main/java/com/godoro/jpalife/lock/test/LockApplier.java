package com.godoro.jpalife.lock.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import com.godoro.jpalife.lock.entity.Shared;

public class LockApplier {
    public static void main(String[] args) {
        long sharedtId = 1;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        // Shared shared = entityManager.find(Shared.class, sharedtId);
        // entityManager.lock(shared, LockModeType.PESSIMISTIC_FORCE_INCREMENT);

        Shared shared = entityManager.find(Shared.class, sharedtId, LockModeType.PESSIMISTIC_FORCE_INCREMENT);

        System.out.println("Sürüm Sayısı: " + shared.getVersionNumber());

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        shared.setSharedName("Üleşilen Ad 5");

        entityManager.merge(shared);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
