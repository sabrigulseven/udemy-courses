package com.godoro.cdiexample.inversion;

public class MySpecificationFinder {
	private static MySpecificationImplementation mySpecificationImplementation;

	public static MySpecification getMySpecification() {
		return mySpecificationImplementation;
	}
}
