package com.openyelp.services.haoservice.lifeservice.joke;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContentList implements Serializable {

	private int error_code;
	
	public int getError_code() {
		return error_code;
	}
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<JokeContent> getResult() {
		return result;
	}
	public void setResult(List<JokeContent> result) {
		this.result = result;
	}
	private String reason;
	private List<JokeContent> result=new ArrayList<JokeContent>();
}
