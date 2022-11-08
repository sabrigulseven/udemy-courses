package com.godoro.inventory.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.inventory.entity.Product;

public class ProductPersist {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		Product product = new Product(0,"Tablet Bilgisayar",5511.0);
		
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(product);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		System.out.println("Ürün Özdeşliği: " + product.getProductId());
	}
}
