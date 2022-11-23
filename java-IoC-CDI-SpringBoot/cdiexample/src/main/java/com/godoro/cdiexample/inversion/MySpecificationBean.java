package com.godoro.cdiexample.inversion;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MySpecificationBean {
	@Inject
	private MySpecification mySpecification;

	public MySpecificationBean() {
		//mySpecification = MySpecificationFinder.getMySpecification();
	}

	public String getMyValue() {
		return " Çıktı: " + mySpecification.myOperatinon("Girdi");
	}
}
