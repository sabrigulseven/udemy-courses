package com.godoro.cdiexample.scope;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class MyDependentBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getValue() {
		return "Bağımlılık " + hashCode();
	}
}
