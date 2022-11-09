package com.godoro.embed.entity;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String provinceName;
    private String districtName;
    private String addressLine1;
    private String addressLine2;

    public Address() {
    }

    public Address(String provinceName, String districtName, String addressLine1, String addressLine2) {
        this.provinceName = provinceName;
        this.districtName = districtName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Address provinceName(String provinceName) {
        setProvinceName(provinceName);
        return this;
    }

    public Address districtName(String districtName) {
        setDistrictName(districtName);
        return this;
    }

    public Address addressLine1(String addressLine1) {
        setAddressLine1(addressLine1);
        return this;
    }

    public Address addressLine2(String addressLine2) {
        setAddressLine2(addressLine2);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(provinceName, address.provinceName) && Objects.equals(districtName, address.districtName) && Objects.equals(addressLine1, address.addressLine1) && Objects.equals(addressLine2, address.addressLine2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinceName, districtName, addressLine1, addressLine2);
    }

    @Override
    public String toString() {
        return "{" +
            " provinceName='" + getProvinceName() + "'" +
            ", districtName='" + getDistrictName() + "'" +
            ", addressLine1='" + getAddressLine1() + "'" +
            ", addressLine2='" + getAddressLine2() + "'" +
            "}";
    }

}
