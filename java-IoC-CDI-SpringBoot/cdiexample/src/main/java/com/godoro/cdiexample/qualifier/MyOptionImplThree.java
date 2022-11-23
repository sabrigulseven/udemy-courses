package com.godoro.cdiexample.qualifier;


@MyOption(MyOptionType.THREE)
public class MyOptionImplThree implements MyOptionSpec {

	public String myOperatinon(String input) {
		return "Gerçekleştirim 3 " + input + " ";
	}

}
