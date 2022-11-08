package com.godoro.jpareal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Customer customer = new Customer(0, "Mahsuni Şerif", 3567);

        entityManager.getTransaction().begin();

        entityManager.persist(customer);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
