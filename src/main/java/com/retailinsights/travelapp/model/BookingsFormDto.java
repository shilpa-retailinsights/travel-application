package com.retailinsights.travelapp.model;

import java.util.UUID;

public class BookingsFormDto {
	private String from_date;
	private String to_date;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private boolean is_paid;
	private int trip_code;
	private UUID payments_id;
	private UUID school_id;
	private UUID itinerary_id;
	private int status_id;
	private String to_address;
	private String from_address;
	private String content;
	private String subject;

	public String getTo_address() {
		return to_address;
	}

	public void setTo_address(String toAddress) {
		this.to_address = toAddress;
	}

	public String getFrom_address() {
		return from_address;
	}

	public void setFrom_address(String fromAddress) {
		this.from_address = fromAddress;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getFrom_date() {
		return from_date;
	}

	public void setFrom_date(String fromDate) {
		this.from_date = fromDate;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String toDate) {
		this.to_date = toDate;
	}

	public boolean getIs_paid() {
		return is_paid;
	}

	public void setIs_paid(boolean isPaid) {
		this.is_paid = isPaid;
	}

	public int getTrip_code() {
		return trip_code;
	}

	public void setTrip_code(int tripCode) {
		this.trip_code = tripCode;
	}

	public UUID getPayments_id() {
		return payments_id;
	}

	public void setPayments_id(UUID paymentsId) {
		this.payments_id = paymentsId;
	}

	public UUID getSchool_id() {
		return school_id;
	}

	public void setSchool_id(UUID schoolId) {
		this.school_id = schoolId;
	}

	public UUID getItinerary_id() {
		return itinerary_id;
	}

	public void setItinerary_id(UUID itineraryId) {
		this.itinerary_id = itineraryId;
	}

}
