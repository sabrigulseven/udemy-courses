package com.godoro.springconfig.source;

public class Bank {
	private String name;

	private double paymentTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPaymentTime(double paymentTime) {
		this.paymentTime = paymentTime;
	}

	public double getPaymentTime() {
		return paymentTime;
	}
}
