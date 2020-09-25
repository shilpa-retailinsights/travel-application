package com.retailinsights.travelapp.model;

import java.util.UUID;
public class EnquiryFormDto {
	private  String name;
	private String subject;
	private String query;
	private String reply;
	private UUID itinerary_id;
	private UUID school_id;
	private UUID admin_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public UUID getItinerary_id() {
		return itinerary_id;
	}
	public void setItinerary_id(UUID itinerary_id) {
		this.itinerary_id = itinerary_id;
	}
	public UUID getSchool_id() {
		return school_id;
	}
	public void setSchool_id(UUID school_id) {
		this.school_id = school_id;
	}
	public UUID getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(UUID admin_id) {
		this.admin_id = admin_id;
	}
}
