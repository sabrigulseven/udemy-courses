package com.godoro.jpareal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SearchedTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();


        
        for (int i = 0; i < 100; i++) {
            entityManager.getTransaction().begin();
            Searched searched = new Searched();
            searched.setSearchedName("Ad "+i);
            searched.setSearchedValue(12345.0+i*100);
            searched.setSearchedCount(i);
            searched.setSingularName("Biricik" +i);
            entityManager.persist(searched);
            entityManager.getTransaction().commit();
        }


        entityManager.close();
    }
}
