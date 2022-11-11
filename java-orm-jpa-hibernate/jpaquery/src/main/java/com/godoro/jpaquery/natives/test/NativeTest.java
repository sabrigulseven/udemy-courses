package com.godoro.jpaquery.natives.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.godoro.jpaquery.entity.Example;

public class NativeTest {       
    public static void main(String[] args) {
        double exampleValueMin = 200;
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String  jpql = "SELECT * from EXAMPLE where  exampleValue > ?" ; 
        Query query1 = entityManager.createNativeQuery(jpql, Example.class);
        query1.setParameter(1, exampleValueMin);
        List<Example> exampleList = query1.getResultList();

        for (Example example : exampleList) {
            System.out.println(example);
        }   

    }
    
}
