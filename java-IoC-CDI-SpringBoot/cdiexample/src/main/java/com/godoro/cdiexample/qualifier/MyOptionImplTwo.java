package com.godoro.cdiexample.qualifier;


@MyOption(MyOptionType.TWO)
public class MyOptionImplTwo implements MyOptionSpec {

	public String myOperatinon(String input) {
		return "Gerçekleştirim 2 " + input + " ";
	}

}
