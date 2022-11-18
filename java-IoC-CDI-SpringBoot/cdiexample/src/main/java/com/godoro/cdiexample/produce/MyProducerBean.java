package com.godoro.cdiexample.produce;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;

public class MyProducerBean {
	@Produces
	public List<String> getMyList() {
		List<String> myList = new ArrayList<>();
		myList.add("Öğe 1");
		myList.add("Öğe 2");
		myList.add("Öğe 3");
		return myList;
	}

	@Produces
	public String[] getMyArray(@New MyParameter myParameter) {
		String[] myArray = new String[myParameter.getLength()];
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = "Madde " + (i+1);
		}
		return myArray;
	}
}
