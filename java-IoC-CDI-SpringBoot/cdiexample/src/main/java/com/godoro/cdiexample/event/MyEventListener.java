package com.godoro.cdiexample.event;

import javax.enterprise.event.Observes;

public class MyEventListener {
	public void listen(@Observes MyEventData myEventData) {
		System.out.println("Olay gerçekleşti" + myEventData.getMyField());
	}
}
