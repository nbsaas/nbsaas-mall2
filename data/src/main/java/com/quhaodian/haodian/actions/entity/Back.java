package com.quhaodian.haodian.actions.entity;

import java.io.Serializable;

public class Back implements Serializable{

	private boolean success;
	
	private String messages;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	
}
