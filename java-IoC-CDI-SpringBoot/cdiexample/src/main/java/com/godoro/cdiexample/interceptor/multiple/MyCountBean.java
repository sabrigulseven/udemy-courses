package com.godoro.cdiexample.interceptor.multiple;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyCountBean {
	@Inject
	private MyCountAscendingObject myCountAscendingObject;
	
	@Inject
	private MyCountDescendingObject myCountDescendingObject;
	
	public String getAscendingValue() {
		myCountAscendingObject.myOperation("Girdi");
		myCountAscendingObject.myOperation("Girdi");
		myCountAscendingObject.myOperation("Girdi");
		myCountAscendingObject.myOperation("Girdi");
		return "Çıktı: " + myCountAscendingObject.myOperation("Girdi");
	}
	
	public String getDescendingValue() {
		myCountDescendingObject.myOperation("Girdi");
		myCountDescendingObject.myOperation("Girdi");
		myCountDescendingObject.myOperation("Girdi");
		myCountDescendingObject.myOperation("Girdi");
		return "Çıktı: " + myCountDescendingObject.myOperation("Girdi");
	}
}
