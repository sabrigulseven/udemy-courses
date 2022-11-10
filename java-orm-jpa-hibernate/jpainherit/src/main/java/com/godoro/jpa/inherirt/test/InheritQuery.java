package com.godoro.jpa.inherirt.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.godoro.jpa.inherirt.entity.Brother;
import com.godoro.jpa.inherirt.entity.Parent;

public class InheritQuery {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String jpql1 = "Select brother from Brother as brother ";
        TypedQuery<Brother> query1 = entityManager.createQuery(jpql1, Brother.class);
        List<Brother> brotherList = query1.getResultList();

        String jpql2 = "Select parent from Parent as parent ";
        TypedQuery<Parent> query2 = entityManager.createQuery(jpql2, Parent.class);
        List<Parent> parentList = query2.getResultList();
        entityManager.close();

        for (Brother brother : brotherList) {
            System.out.println(brother);
        }

        System.out.println("------------------------------------------------");

        for (Parent parent : parentList) {
            if (parent instanceof Brother) {
                Brother brother = (Brother)parent;
                System.out.println(brother);
            }
        }
    }
}
