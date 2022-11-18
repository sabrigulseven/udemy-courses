package com.godorocdiexample.name;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("myPresiousOne")
@RequestScoped
public class MyBeanTwo {
	private String myProperty;
	
	public MyBeanTwo() {
		myProperty = "godoro";
	}
	
	public String getMyProperty() {
		return myProperty;
	}

	public void setMyProperty(String myProperty) {
		this.myProperty = myProperty;
	}
	
}
