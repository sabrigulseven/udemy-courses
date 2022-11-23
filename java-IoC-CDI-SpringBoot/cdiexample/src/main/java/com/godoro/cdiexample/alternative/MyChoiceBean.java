package com.godoro.cdiexample.alternative;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyChoiceBean {
	@Inject
	private MyChoiceSpecification myChoiceSpecification;


	public String getMyValue() {
		return " Çıktı: " + myChoiceSpecification.myOperatinon("Girdi");
	}
}
