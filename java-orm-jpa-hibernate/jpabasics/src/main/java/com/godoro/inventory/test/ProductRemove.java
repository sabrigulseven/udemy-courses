package com.godoro.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.inventory.entity.Product;

public class ProductRemove {
    public static void main(String[] args) {
        long productId = 1;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        Product product = entityManager.getReference(Product.class, productId);
        entityManager.remove(product);
        entityManager.getTransaction().commit();

        entityManager.close();
        System.out.println(product.getProductId()+" "+product.getProductName()+ " "+ product.getSalesPrice());

    }
}
