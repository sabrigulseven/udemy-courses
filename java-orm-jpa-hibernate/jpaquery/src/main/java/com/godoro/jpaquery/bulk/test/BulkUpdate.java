package com.godoro.jpaquery.bulk.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BulkUpdate {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        String jpql = "update Example as e " +
                "set e.exampleName = CONCAT(:namePrefix,e.exampleName)";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("namePrefix", "En");
        int affected = query.executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();

        System.out.println("Etkilenen: " + affected);
    }
}
