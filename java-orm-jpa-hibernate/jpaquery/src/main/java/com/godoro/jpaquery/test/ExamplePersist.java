package com.godoro.jpaquery.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpaquery.entity.Example;

public class ExamplePersist {
    public static void main(String[] args) {
        Example example1 = new Example(0, "Örnek Ad 1111", 111);
        Example example2 = new Example(0, "Örnek Ad 222", 222);
        Example example3 = new Example(0, "Örnek Ad 333", 333);

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(example1);
        entityManager.persist(example2);
        entityManager.persist(example3);
        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
