package com.godoro.cdiexample.event;

import java.io.Serializable;

import javax.enterprise.util.AnnotationLiteral;

public class MyEventQualifierLiteral extends AnnotationLiteral<MyEventQualifier>
		implements MyEventQualifier, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 565395047158118325L;
	private final int level;

	public MyEventQualifierLiteral(int level) {
		this.level = level;
	}

	@Override
	public int level() {
		
		return level;
	}

}
