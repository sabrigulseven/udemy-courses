package com.godoro.springconfig.basics.bean;

public class MyBean {
	private long myLong;
	private String myString;
	private double myDouble;


	public MyBean() {
	}

	public MyBean(long myLong, String myString, double myDouble) {
		this.myLong = myLong;
		this.myString = myString;
		this.myDouble = myDouble;
	}

	public long getMyLong() {
		return this.myLong;
	}

	public void setMyLong(long myLong) {
		this.myLong = myLong;
	}

	public String getMyString() {
		return this.myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	public double getMyDouble() {
		return this.myDouble;
	}

	public void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}
	public void initializeBean() {
		System.out.println("Başlatılıyor..");
	}
	
	public void finalizeBean() {
		System.out.println("Sonlandırılıyor..");
	}
	@Override
	public String toString() {
		return "{" +
			" myLong='" + getMyLong() + "'" +
			", myString='" + getMyString() + "'" +
			", myDouble='" + getMyDouble() + "'" +
			"}";
	}
	
}
