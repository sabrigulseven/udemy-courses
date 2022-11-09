package com.godoro.composite.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.composite.entity.Director;
import com.godoro.composite.entity.DirectorId;

public class IdClassFind {
    public static void main(String[] args) {
        long employeeId = 4;
        long projectId = 3;
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();
        DirectorId directorId = new DirectorId(employeeId, projectId);
        Director director = entityManager.find(Director.class, directorId);

        entityManager.close();
        System.out.println(director.toString());
    }
}
