package com.godoro.cdiexample.event;

public class MyEventData {
	private String myField;

	public MyEventData() {

	}

	public MyEventData(String myField) {
		super();
		this.myField = myField;
	}

	public String getMyField() {
		return myField;
	}

	public void setMyField(String myField) {
		this.myField = myField;
	}
}
