package com.godoro.cdiexample.scope;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MyApplicationBean {
	
	public String getMyValue() {
		return "Uygulama " + hashCode();
	}
}
