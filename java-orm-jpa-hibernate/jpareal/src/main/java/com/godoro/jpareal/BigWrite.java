package com.godoro.jpareal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BigWrite {
    public static void main(String[] args) throws IOException {


        String bigText =new String(Files.readAllBytes(Paths.get("mytext.txt")));
        byte[] bigBytes=Files.readAllBytes(Paths.get("myimage.jpg"));

        Big big = new Big();
        big.setBigText(bigText);
        big.setBigBytes(bigBytes);
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(big);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
