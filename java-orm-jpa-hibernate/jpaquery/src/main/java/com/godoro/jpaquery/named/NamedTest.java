package com.godoro.jpaquery.named;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.godoro.jpaquery.entity.Example;

public class NamedTest {
    public static void main(String[] args) {
        double exampleValueMin = 200;
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        TypedQuery<Example> query1 = entityManager.createNamedQuery("Example.findAll", Example.class);
        query1.setParameter("exampleValueMin", exampleValueMin);
        List<Example> exampleList = query1.getResultList();

        for (Example example : exampleList) {
            System.out.println(example);
        }

    }
}
