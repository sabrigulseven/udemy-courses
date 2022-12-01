package com.godoro.cdiexample.event;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MyEventBean {
	@Inject
	private Event<MyEventData> event;
	@Inject
	private @MyEventQualifier(level = 2) Event<MyEventData> event2;
	@Inject
	private @MyEventQualifier(level = 4) Event<MyEventData> event4;

	public void perform() {
		event.fire(new MyEventData("Genel Olay"));
		event2.fire(new MyEventData("2. Düzey Olay"));
		event4.fire(new MyEventData("4. Düzey Olay"));
		
		event.select(new MyEventQualifierLiteral(2)).fire(new MyEventData("Niteleyici İmceli 2.Düzey Olay"));
	}

}
