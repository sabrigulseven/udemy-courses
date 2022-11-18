package com.godoro.cdiexample.scope;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class MyApplicationBean {
	@Inject
	private MyDependentBean myDependentBean;

	public String getMyValue() {
		return "Uygulama " + hashCode();
	}

	public String getDependentValue() {
		return "Uygulama " + myDependentBean.getValue();
	}
}
