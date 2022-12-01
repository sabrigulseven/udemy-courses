package com.godoro.cdiexample.event;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyEventBean {
	@Inject
	Event<MyEventData> event;

	public void perform() {
		event.fire(new MyEventData("Genel Olay"));
	}

}
