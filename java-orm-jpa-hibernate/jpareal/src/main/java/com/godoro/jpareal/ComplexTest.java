package com.godoro.jpareal;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComplexTest {
    public static void main(String[] args) {

        Complex complex = new Complex();
        complex.setComplexName("karmaşık ad");
        complex.setComplexValue(342.45);
        complex.setComplexKind(ComplexKind.MEDIUM);
        complex.setComplexDate(new Date(System.currentTimeMillis()));
        complex.setTemporaryField("geçici değer");
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(complex);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
