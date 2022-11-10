package com.godoro.jpa.mapped.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.godoro.jpa.mapped.entity.Customer;

public class MappedQuery {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("MyPersistenceUnit");
		EntityManager entityManager = factory.createEntityManager();

        String jpql = "Select customer from Customer as customer ";

        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        List<Customer> customerList= query.getResultList();

        entityManager.close();

        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }
}
