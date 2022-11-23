package com.godoro.cdiexample.qualifier;


@MyOption(MyOptionType.ONE)
public class MyOptionImplOne implements MyOptionSpec {

	public String myOperatinon(String input) {
		return "Gerçekleştirim 1 " + input + " ";
	}

}
