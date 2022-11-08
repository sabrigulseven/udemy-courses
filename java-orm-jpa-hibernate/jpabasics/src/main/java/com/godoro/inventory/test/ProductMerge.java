package com.godoro.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.inventory.entity.Product;

public class ProductMerge {
    public static void main(String[] args) {
        long productId = 1;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        Product product = entityManager.find(Product.class, productId);
        product.setProductName("Masaüstü Bilgisayar");
        entityManager.merge(product);

        entityManager.getTransaction().commit();

        entityManager.close();


    }
}
