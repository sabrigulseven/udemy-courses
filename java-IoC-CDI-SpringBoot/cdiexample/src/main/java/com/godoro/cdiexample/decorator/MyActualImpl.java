package com.godoro.cdiexample.decorator;

public class MyActualImpl implements MyActualSpec{

	@Override
	public String myOperationOne(String input) {
		return "Çıktı 1" + input;
	}

	@Override
	public String myOperationTwo(String input) {
		return "Çıktı 2" + input;
	}

}
