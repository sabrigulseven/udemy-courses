package com.godoro.cdiexample.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
abstract class MyActualDecorator implements MyActualSpec {
	private @Inject @Delegate MyActualSpec myActualSpec;
	@Override
	public String myOperationOne(String input) {
		System.out.println("Bezeyici çalıştı.. ");
		String output = myActualSpec.myOperationOne(input);
		if (input.contains("Godoro")) {
			output = output.replace("Godoro", "Godoro (TM)");
		}
		return output;
	}


}
