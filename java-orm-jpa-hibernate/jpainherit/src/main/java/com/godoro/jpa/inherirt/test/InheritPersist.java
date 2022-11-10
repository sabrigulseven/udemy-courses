package com.godoro.jpa.inherirt.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.jpa.inherirt.entity.Brother;
import com.godoro.jpa.inherirt.entity.Sister;

public class InheritPersist {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Brother brother1 = new Brother(0, "Mahsuni Şerif", 3567, true);
        Brother brother2 = new Brother(0, "Aşık Veysel", 4556, false);
        Sister sister1 = new Sister(0, "Barış Manço", 6731, (short) 32);
        Sister sister2 = new Sister(0, "Erkin Koray", 5672, (short) 23);

        entityManager.getTransaction().begin();

        entityManager.persist(brother1);
        entityManager.persist(brother2);
        entityManager.persist(sister1);
        entityManager.persist(sister2);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
