package com.godoro.cdiexample.inject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyConstructorBean {
	
	private MyTool myTool;

	
	public String getMyValue() {
		return "Tarla Inject " + myTool.myOperation("Girdi");

	}
	@Inject
	public MyConstructorBean(MyTool myTool) {
		this.myTool = myTool;
		System.out.println("Araç kuruldu...");
	}
	public MyConstructorBean() {
		
	}
}
