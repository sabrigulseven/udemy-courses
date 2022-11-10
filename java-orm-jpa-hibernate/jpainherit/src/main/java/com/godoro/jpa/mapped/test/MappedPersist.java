package com.godoro.jpa.mapped.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpa.mapped.entity.Customer;
import com.godoro.jpa.mapped.entity.Supplier;

public class MappedPersist {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Customer customer1 = new Customer(0, "Mahsuni Şerif", 3567);
        Customer customer2 = new Customer(0, "Aşık Veysel", 4556);
        Supplier supplier1 = new Supplier(0, "Barış Manço", 6731);
        Supplier supplier2 = new Supplier(0, "Erkin Koray", 5672);

        entityManager.getTransaction().begin();

        entityManager.persist(customer1);
        entityManager.persist(customer2);
        entityManager.persist(supplier1);
        entityManager.persist(supplier2);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
