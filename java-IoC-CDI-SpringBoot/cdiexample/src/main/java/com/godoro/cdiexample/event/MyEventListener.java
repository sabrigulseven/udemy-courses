package com.godoro.cdiexample.event;

import javax.enterprise.event.Observes;

public class MyEventListener {
	public void listen(@Observes MyEventData myEventData) {
		System.out.println("Genel gözlemci: " + myEventData.getMyField());
	}
	public void listen2(@Observes @MyEventQualifier(level = 2) MyEventData myEventData) {
		System.out.println("2. Düzey gözlemci: " + myEventData.getMyField());
	}
}
