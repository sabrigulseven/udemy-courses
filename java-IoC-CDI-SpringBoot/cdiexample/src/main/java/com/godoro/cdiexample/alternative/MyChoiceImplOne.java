package com.godoro.cdiexample.alternative;

import javax.enterprise.inject.Alternative;

@Alternative
public class MyChoiceImplOne implements MyChoiceSpecification {

	public String myOperatinon(String input) {
		return "Gerçekleştirim 1 " + input + " ";
	}

}
