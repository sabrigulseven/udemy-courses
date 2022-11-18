package com.godoro.cdiexample.scope;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyRequestBean {
	@Inject
	private MyDependentBean myDependentBean;
	
	public String getMyValue() {
		return "İstek " + hashCode();
	}

	public String getDependentValue() {
		return "İstek " + myDependentBean.getValue();
	}
}
