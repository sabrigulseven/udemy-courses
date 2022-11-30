package com.godoro.cdiexample.interceptor.multiple;

@MyCountBinding(ascending = true)
public class MyCountAscendingObject {
	public String myOperation(String input) {
		return "Yükselen Çıktı: " + input;
	}
}
