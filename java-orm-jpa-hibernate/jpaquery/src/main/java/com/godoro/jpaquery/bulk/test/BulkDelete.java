package com.godoro.jpaquery.bulk.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class BulkDelete {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        String jpql = "delete Example as e " +
                "where e.exampleName LIKE :namePattern";

        Query query = entityManager.createQuery(jpql);
        query.setParameter("namePattern", "%Gün%");
        int affected = query.executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();

        System.out.println("Etkilenen: " + affected);
    }
}
