package com.retailinsights.travelapp.exceptions;

import java.util.Date;

public class CustomExceptionHandling {

	private Date timestamp;
	private String message;
	public CustomExceptionHandling() {
		super();
	}
	public CustomExceptionHandling(Date timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMsg() {
		return message;
	}
	public void setMsg(String msg) {
		this.message = msg;
	}
		
}
