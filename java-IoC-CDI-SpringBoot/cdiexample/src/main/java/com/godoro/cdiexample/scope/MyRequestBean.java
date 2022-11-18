package com.godoro.cdiexample.scope;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MyRequestBean {
	
	public String getMyValue() {
		return "İstek " + hashCode();
	}
}
