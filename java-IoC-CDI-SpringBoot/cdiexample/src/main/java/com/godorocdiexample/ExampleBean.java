package com.godorocdiexample;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ExampleBean {
	private String myProperty;
	
	public ExampleBean() {
		myProperty = "godoro";
	}
	
	public String getMyProperty() {
		return myProperty;
	}

	public void setMyProperty(String myProperty) {
		this.myProperty = myProperty;
	}
	
}
