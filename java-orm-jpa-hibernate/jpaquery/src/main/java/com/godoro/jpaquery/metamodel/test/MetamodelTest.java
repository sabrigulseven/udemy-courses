package com.godoro.jpaquery.metamodel.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

import com.godoro.jpaquery.entity.Example;

public class MetamodelTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Metamodel metamodel = entityManager.getMetamodel();
        EntityType<Example> example = metamodel.entity(Example.class);
        for (Attribute<?, ?> attribute : example.getAttributes()) {
            if (attribute instanceof SingularAttribute) {
                System.out.println(attribute.getName() + " " + attribute.getJavaType());
            }

        }

        entityManager.close();

    }
}
