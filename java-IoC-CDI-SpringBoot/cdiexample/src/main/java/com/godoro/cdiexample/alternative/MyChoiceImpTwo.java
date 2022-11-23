package com.godoro.cdiexample.alternative;

import javax.enterprise.inject.Alternative;

@Alternative
public class MyChoiceImpTwo implements MyChoiceSpecification {

	public String myOperatinon(String input) {
		return "Gerçekleştirim 2 " + input + " ";
	}

}
