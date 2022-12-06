package com.godoro.springclient.bussiness.dto;

public class ProductDto {
	private long productId;
	private String productName;
	private double salesPrice;

	public ProductDto() {
		
	}

	public ProductDto(long productId, String productName, double salesPrice) {
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

	@Override
	public String toString() {
		return "{" + " productId='" + getProductId() + "'" + ", productName='" + getProductName() + "'"
				+ ", salesPrice='" + getSalesPrice() + "'" + "}";
	}

}
