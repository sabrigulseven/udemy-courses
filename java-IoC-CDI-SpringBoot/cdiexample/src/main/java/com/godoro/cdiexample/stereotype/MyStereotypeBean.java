package com.godoro.cdiexample.stereotype;

/*
@Named
@ApplicationScoped
@MyCountBinding(ascending =  false)
@MyTraceBinding
*/
@MyStereotypeAnnotation
public class MyStereotypeBean {

	public String getValue() {
		return "Basmakalıp çekirdek" + hashCode();
	}
}
