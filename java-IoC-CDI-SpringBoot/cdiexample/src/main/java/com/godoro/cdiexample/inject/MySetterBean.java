package com.godoro.cdiexample.inject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MySetterBean {
	
	private MyTool myTool;
	
	@Inject
	public void setMyTool(MyTool myTool) {
		this.myTool = myTool;
		System.out.println("Araç takıldı...");
	}
	public String getMyValue() {
		return "Tarla Inject " + myTool.myOperation("Girdi");

	}
}
