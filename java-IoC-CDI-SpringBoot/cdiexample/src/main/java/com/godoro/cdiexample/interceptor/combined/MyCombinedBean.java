package com.godoro.cdiexample.interceptor.combined;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyCombinedBean {
	@Inject
	private MyCombinedObject myCombinedObject;

	public String getMyValue() {
		return "Çıktı: " + myCombinedObject.myOperation("Girdi");
	}
}
