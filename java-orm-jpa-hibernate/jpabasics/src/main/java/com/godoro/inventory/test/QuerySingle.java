package com.godoro.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.godoro.inventory.entity.Product;

public class QuerySingle {
    public static void main(String[] args) {
        Product product;
        try {
            double salesPriceMin = 1340;
            EntityManagerFactory factory = Persistence
                    .createEntityManagerFactory("MyPersistenceUnit");
            EntityManager entityManager = factory.createEntityManager();

            String jpql = "Select product from Product as product where product.salesPrice = :salesPriceMin";

            TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
            query.setParameter("salesPriceMin", salesPriceMin);
            product = query.getSingleResult();

            entityManager.close();

        } catch (NoResultException e) {
            product = null;
        }
        if (product != null) {
            System.out.println(product.getProductId() + " - "
                    + product.getProductName() + " - "
                    + product.getSalesPrice());
        }

    }
}
