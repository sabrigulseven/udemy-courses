package com.godoro.cdiexample.interceptor.combined;

//@MyTraceBinding
//@MyCountBinding(ascending = true)
@MyCombinedBinding(ascending = true)
public class MyCombinedObject {
	public String myOperation(String input) {
		return " Çıktı: " + input;
	}
}
