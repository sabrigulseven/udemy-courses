package com.sabrigulseven.houseapi.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class House {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String propertyName;
	private int price;
	private String houseType;
	private int areaInSqFt;
	private int noOfBedrooms;
	private int noOfBathrooms;
	private int noOfReceptions;
	private String location;
	private String cityCountry;
	private String postalCode;

	public House() {
	}

	public House(long id, String propertyName, int price, String houseType, int areaInSqFt, int noOfBedrooms,
			int noOfBathrooms, int noOfReceptions, String location, String cityCountry, String postalCode) {
		this.id = id;
		this.propertyName = propertyName;
		this.price = price;
		this.houseType = houseType;
		this.areaInSqFt = areaInSqFt;
		this.noOfBedrooms = noOfBedrooms;
		this.noOfBathrooms = noOfBathrooms;
		this.noOfReceptions = noOfReceptions;
		this.location = location;
		this.cityCountry = cityCountry;
		this.postalCode = postalCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public int getAreaInSqFt() {
		return areaInSqFt;
	}

	public void setAreaInSqFt(int areaInSqFt) {
		this.areaInSqFt = areaInSqFt;
	}

	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}

	public void setNoOfBedrooms(int noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}

	public int getNoOfBathrooms() {
		return noOfBathrooms;
	}

	public void setNoOfBathrooms(int noOfBathrooms) {
		this.noOfBathrooms = noOfBathrooms;
	}

	public int getNoOfReceptions() {
		return noOfReceptions;
	}

	public void setNoOfReceptions(int noOfReceptions) {
		this.noOfReceptions = noOfReceptions;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCityCountry() {
		return cityCountry;
	}

	public void setCityCountry(String cityCountry) {
		this.cityCountry = cityCountry;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
