package com.godoro.jpalife.cache.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpalife.cache.entity.Frequent;

public class FirstLevelFind {
    public static void main(String[] args) {
        long frequentId = 1;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Frequent frequent1 = entityManager.find(Frequent.class, frequentId);
        System.out.println(frequent1);
        entityManager.refresh(frequent1);
        Frequent frequent2 = entityManager.find(Frequent.class, frequentId);
        System.out.println(frequent2);

        entityManager.close();

        EntityManager entityManager2 = factory.createEntityManager();

        Frequent frequent1b = entityManager2.find(Frequent.class, frequentId);
        System.out.println(frequent1b);

        Frequent frequent2b = entityManager2.find(Frequent.class, frequentId);
        System.out.println(frequent2b);

        entityManager2.close();

    }
}
