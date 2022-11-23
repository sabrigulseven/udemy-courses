package com.godoro.cdiexample.qualifier;

import javax.enterprise.inject.Default;

@Default
public class MyOptionImplZero implements MyOptionSpec {

	public String myOperatinon(String input) {
		return "Gerçekleştirim 0 " + input + " ";
	}

}
