package com.godoro.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.inventory.entity.Product;

public class ProductFind {
    public static void main(String[] args) {
        long productId = 1;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        Product product = entityManager.find(Product.class, productId);
        entityManager.close();

        System.out.println(product.getProductId()+" "+product.getProductName()+ " "+ product.getSalesPrice());

    }
}
