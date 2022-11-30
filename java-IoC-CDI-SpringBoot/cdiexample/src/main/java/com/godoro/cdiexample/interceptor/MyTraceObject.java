package com.godoro.cdiexample.interceptor;

@MyTraceBinding
public class MyTraceObject {
	public String myOperation(String input) {
		return "Çıktı: " + input;
	}
}
