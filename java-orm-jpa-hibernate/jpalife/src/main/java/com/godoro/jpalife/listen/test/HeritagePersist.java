package com.godoro.jpalife.listen.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpalife.listen.entity.Kid;

public class HeritagePersist {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Kid kid = new Kid();
        kid.setNameField("Çocuk 1");
        

        entityManager.getTransaction().begin();

        entityManager.persist(kid);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
