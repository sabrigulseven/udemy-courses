package com.godoro.jpaquery.criteria.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.godoro.jpaquery.entity.Example;
import com.godoro.jpaquery.entity.Example_;

public class CriteriaMetaModel {
    public static void main(String[] args) {
        double exampleValueMin = 200;
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Example> criteria = builder.createQuery(Example.class);
        Root<Example> root = criteria.from(Example.class);
        Predicate condition = builder
                .gt(root.<Double>get(Example_.exampleValue), exampleValueMin);
        criteria.where(condition);
        TypedQuery<Example> query = entityManager.createQuery(criteria);
        List<Example> exampleList = query.getResultList();

        for (Example e : exampleList) {
            System.out.println(e);
        }
    }
}
