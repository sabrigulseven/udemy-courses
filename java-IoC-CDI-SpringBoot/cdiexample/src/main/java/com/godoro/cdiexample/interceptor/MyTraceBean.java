package com.godoro.cdiexample.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyTraceBean {
	@Inject
	private MyTraceObject myTraceObject;

	public String getMyValue() {
		return "Çıktı: " + myTraceObject.myOperation("Girdi");
	}
}
