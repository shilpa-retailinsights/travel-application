package com.retailinsights.travelapp.entiry;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Invoices {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String tracking_status;
	private String track_started_date;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Bookings booking;
	
	private String  description;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address address; 
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Schools school;
	
	public Invoices() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoices(UUID id, String trackingStatus, String trackStartedDate, Bookings booking, String description,
			Address address, Schools school) {
		super();
		this.id = id;
		this.tracking_status = trackingStatus;
		this.track_started_date = trackStartedDate;
		this.booking = booking;
		this.description = description;
		this.address = address;
		this.school = school;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getTrackingStatus() {
		return tracking_status;
	}

	public void setTrackingStatus(String trackingStatus) {
		this.tracking_status = trackingStatus;
	}

	public String getTrackStartedDate() {
		return track_started_date;
	}

	public void setTrackStartedDate(String trackStartedDate) {
		this.track_started_date = trackStartedDate;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Schools getSchool() {
		return school;
	}

	public void setSchool(Schools school) {
		this.school = school;
	}

	
	 
	
}
