package com.godoro.cdiexample.scope;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MySessionBean implements Serializable {
	
	public String getMyValue() {
		return "Oturum " + hashCode();
	}
}
