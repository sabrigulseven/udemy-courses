package com.godoro.springapp.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private double salesPrice;

	public Product() {
	}

	public Product(long productId, String productName, double salesPrice) {
		this.productId = productId;
		this.productName = productName;
		this.salesPrice = salesPrice;
	}

	public long getProductId() {
		return this.productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getSalesPrice() {
		return this.salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public Product productId(long productId) {
		setProductId(productId);
		return this;
	}

	public Product productName(String productName) {
		setProductName(productName);
		return this;
	}

	public Product salesPrice(double salesPrice) {
		setSalesPrice(salesPrice);
		return this;
	}

	@Override
	public String toString() {
		return "{" + " productId='" + getProductId() + "'" + ", productName='" + getProductName() + "'"
				+ ", salesPrice='" + getSalesPrice() + "'" + "}";
	}

}
