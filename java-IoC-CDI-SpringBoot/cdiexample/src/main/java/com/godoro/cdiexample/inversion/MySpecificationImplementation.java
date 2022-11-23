package com.godoro.cdiexample.inversion;

public class MySpecificationImplementation implements MySpecification {
	public String myOperatinon(String input) {
		return "Gerçekleştirim: " + input;
	}
}
