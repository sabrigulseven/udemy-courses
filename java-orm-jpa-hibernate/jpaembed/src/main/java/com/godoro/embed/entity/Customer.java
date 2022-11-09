package com.godoro.embed.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String customerName;
	@Embedded
	private Address address;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer(long customerId, String customerName, Address address) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
	}

	public Customer() {
	}

}
