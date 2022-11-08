package com.godoro.inventory.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.godoro.inventory.entity.Product;

public class QueryList {
    public static void main(String[] args) {
        double salesPriceMin = 4500;
        EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

        String jpql = "Select product from Product as product where product.salesPrice > :salesPriceMin";

        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        query.setParameter("salesPriceMin", salesPriceMin);
        List<Product> productList= query.getResultList();

        entityManager.close();

        for (Product product : productList) {
            System.out.println(product.getProductId()+" - "
                    +product.getProductName()+" - "
                    +product.getSalesPrice());
        }
    }
}
