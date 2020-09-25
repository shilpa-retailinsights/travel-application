package com.retailinsights.travelapp.model;

import java.util.UUID;
public class InvoicesFormDto {

	private  String tracking_status;
	private String track_started_date;
	private String description;
	private UUID booking_id;
	private UUID address_id; 
	private UUID school_id;
	public String getTracking_status() {
		return tracking_status;
	}
	public void setTracking_status(String tracking_status) {
		this.tracking_status = tracking_status;
	}
	public String getTrack_started_date() {
		return track_started_date;
	}
	public void setTrack_started_date(String track_started_date) {
		this.track_started_date = track_started_date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UUID getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(UUID booking_id) {
		this.booking_id = booking_id;
	}
	public UUID getAddress_id() {
		return address_id;
	}
	public void setAddress_id(UUID address_id) {
		this.address_id = address_id;
	}
	public UUID getSchool_id() {
		return school_id;
	}
	public void setSchool_id(UUID school_id) {
		this.school_id = school_id;
	}
}
