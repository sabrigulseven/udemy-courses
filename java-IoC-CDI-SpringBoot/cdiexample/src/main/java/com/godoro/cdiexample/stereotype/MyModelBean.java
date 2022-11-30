package com.godoro.cdiexample.stereotype;

import javax.enterprise.inject.Model;

@Model
public class MyModelBean {
	public String getValue() {
		return "Taslam çekirdek" + hashCode();
	}
}
