package com.godoro.springtemplates.crud;

public class Example {
	private long exampleId;
	private String exampleName;
	private double exampleValue;

	public Example() {

	}

	public Example(long exampleId, String exampleName, double exampleValue) {
		this.exampleId = exampleId;
		this.exampleName = exampleName;
		this.exampleValue = exampleValue;
	}

	public long getExampleId() {
		return exampleId;
	}

	public void setExampleId(long exampleId) {
		this.exampleId = exampleId;
	}

	public String getExampleName() {
		return exampleName;
	}

	public void setExampleName(String exampleName) {
		this.exampleName = exampleName;
	}

	public double getExampleValue() {
		return exampleValue;
	}

	public void setExampleValue(double exampleValue) {
		this.exampleValue = exampleValue;
	}

	@Override
	public String toString() {
		return "Example [exampleId=" + exampleId + ", exampleName=" + exampleName + ", exampleValue=" + exampleValue
				+ "]";
	}

}
