package com.godoro.embed.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.godoro.embed.entity.Customer;

public class CustomerQuery {
    public static void main(String[] args) {
        String districtName = "Kadıköy";
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String jpql = "Select customer from Customer as customer where customer.address.districtName = :districtName";

        TypedQuery<Customer> query = entityManager.createQuery(jpql, Customer.class);
        query.setParameter("districtName", districtName);
        List<Customer> customerList = query.getResultList();

        entityManager.close();
        for (Customer customer : customerList) {
            System.out.println(customer.getCustomerId() + " " + customer.getCustomerName() + " "
                + customer.getAddress().getProvinceName());
    
        }
    }
}
