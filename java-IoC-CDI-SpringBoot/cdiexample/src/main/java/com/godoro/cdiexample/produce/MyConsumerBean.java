package com.godoro.cdiexample.produce;

import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyConsumerBean {
	@Inject
	private List<String> ourList;
	
	@Inject
	private String[] ourArray;
	
	public List<String> getOurList() {
		return ourList;
	}
	
	public String getOurArrayString() {
		StringBuilder builder  = new StringBuilder();
		for(String item: ourArray ) {
			builder.append(item).append(" ");
		}
		return builder.toString();
	}
}
