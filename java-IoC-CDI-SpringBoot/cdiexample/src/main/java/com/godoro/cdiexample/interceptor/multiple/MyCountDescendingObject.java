package com.godoro.cdiexample.interceptor.multiple;

@MyCountBinding(ascending = false)
public class MyCountDescendingObject {
	public String myOperation(String input) {
		return "Alçalan Çıktı: " + input;
	}
}
