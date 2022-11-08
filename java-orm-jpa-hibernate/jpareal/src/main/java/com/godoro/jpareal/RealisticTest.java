package com.godoro.jpareal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RealisticTest {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();
		
		Realistic realistic = new Realistic(0,"Edip Akbayram",1231);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(realistic);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}
}
