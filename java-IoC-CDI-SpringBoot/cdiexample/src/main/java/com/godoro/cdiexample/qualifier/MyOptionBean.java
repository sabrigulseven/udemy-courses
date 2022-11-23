package com.godoro.cdiexample.qualifier;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyOptionBean {
	@Inject @MyOption(MyOptionType.TWO)
	private MyOptionSpec myOptionSpecification;


	public String getMyValue() {
		return " Çıktı: " + myOptionSpecification.myOperatinon("Girdi");
	}
}
