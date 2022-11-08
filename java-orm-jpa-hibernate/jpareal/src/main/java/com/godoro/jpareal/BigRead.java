package com.godoro.jpareal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BigRead {
    public static void main(String[] args) throws IOException {
        
        long bigId = 2;
        
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        
        Big big = entityManager.find(Big.class, bigId);

        entityManager.close();
        String bString = big.getBigText();
        byte[] bigBytes = big.getBigBytes();
        
        Files.write(Paths.get("newtext.txt"), bString.getBytes());
        Files.write(Paths.get("newimage.jpg"), bigBytes);
    }
}
