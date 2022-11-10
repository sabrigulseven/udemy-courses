package com.godoro.jpalife.cache.test;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpalife.cache.entity.Frequent;

public class SecondLevelFind {
    public static void main(String[] args) {
        long frequentId = 1;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Cache cache = factory.getCache();

        Frequent frequent1 = entityManager.find(Frequent.class, frequentId);
        System.out.println(frequent1);
        System.out.println("Zulada mı: " + cache.contains(Frequent.class, frequentId));
        cache.evict(Frequent.class, frequentId); // evicts entity
        cache.evict(Frequent.class); // evicts class
        cache.evictAll(); // evicts all
        System.out.println("Zulada mı: " + cache.contains(Frequent.class, frequentId));

        entityManager.close();

    }
}
