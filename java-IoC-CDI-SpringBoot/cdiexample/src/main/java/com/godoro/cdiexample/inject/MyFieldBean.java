package com.godoro.cdiexample.inject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyFieldBean {
	@Inject
	private MyTool myTool;
	//private MyTool myTool = new MyTool();

	public String getMyValue() {
		return "Tarla Inject " + myTool.myOperation("Girdi");

	}
}
