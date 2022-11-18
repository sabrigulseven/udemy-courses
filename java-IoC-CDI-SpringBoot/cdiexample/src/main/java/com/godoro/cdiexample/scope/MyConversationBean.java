package com.godoro.cdiexample.scope;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class MyConversationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int myValue;

	@Inject
	private Conversation conversation;

	public String getMyValue() {
		return "Söyleşi " + conversation.getId() + " Değer: " + myValue;
	}

	public void startOperation() {
		myValue = 10;
		conversation.begin();
		//conversation.setTimeout(600000);
	}

	public void continueOperation() {
		myValue++;
	}

	public void endOperation() {
		conversation.end();
	}
}
