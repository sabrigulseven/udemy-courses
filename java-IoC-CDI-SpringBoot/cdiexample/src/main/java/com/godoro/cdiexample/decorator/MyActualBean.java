package com.godoro.cdiexample.decorator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyActualBean {
	@Inject
	private MyActualSpec myActualSpec;

	public String getMyValueOne() {
		return "Çıktı: " + myActualSpec.myOperationOne("Godoro");
	}
	
	public String getMyValueTwo() {
		return "Çıktı: " + myActualSpec.myOperationTwo("Fibiler");
	}
}
