package com.godoro.jpalife.cache.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpalife.cache.entity.Frequent;

public class FirstLevelPersist {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Frequent frequent = new Frequent(0,"Sıklık Adı");
        

        entityManager.getTransaction().begin();

        entityManager.persist(frequent);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
