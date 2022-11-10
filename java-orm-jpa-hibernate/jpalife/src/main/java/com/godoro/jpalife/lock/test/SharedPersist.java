package com.godoro.jpalife.lock.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpalife.lock.entity.Shared;

public class SharedPersist {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Shared shared = new Shared(0,"Üleşilen Ad");
        

        entityManager.getTransaction().begin();

        entityManager.persist(shared);

        entityManager.getTransaction().commit();

        entityManager.close();

        System.out.println(shared);
    }
}
