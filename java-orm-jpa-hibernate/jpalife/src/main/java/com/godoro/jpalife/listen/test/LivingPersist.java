package com.godoro.jpalife.listen.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpalife.listen.entity.Living;

public class LivingPersist {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Living living = new Living();
        living.setFirstName("");
        living.setLastName("");

        entityManager.getTransaction().begin();

        entityManager.persist(living);

        entityManager.getTransaction().commit();

        entityManager.close();

        System.out.println(living);
    }
}
