package com.godoro.embed.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.godoro.embed.entity.Address;
import com.godoro.embed.entity.Customer;

public class CustomerPersist {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setCustomerName("Barış Manço");

        Address address = new Address();
        address.setProvinceName("İstanbul");
        address.setDistrictName("Kadıköy");
        address.setAddressLine1("Moda.");
        address.setAddressLine2("No 9s.");
        customer.setAddress(address);

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(customer);

        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
