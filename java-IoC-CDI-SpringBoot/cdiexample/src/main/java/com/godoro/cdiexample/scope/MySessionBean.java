package com.godoro.cdiexample.scope;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class MySessionBean implements Serializable {
	@Inject
	private MyDependentBean myDependentBean;

	public String getMyValue() {
		return "Oturum " + hashCode();
	}
	public String getDependentValue() {
		return "Oturum " + myDependentBean.getValue();
	}
	
}
