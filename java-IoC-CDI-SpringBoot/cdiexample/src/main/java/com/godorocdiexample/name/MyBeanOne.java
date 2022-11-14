package com.godorocdiexample.name;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MyBeanOne {
	private String myProperty;
	public String getMyProperty() {
		return myProperty;
	}
	public void setMyProperty(String myProperty) {
		this.myProperty = myProperty;
	}
	public MyBeanOne() {
		myProperty = "Godoro";
	}
}
