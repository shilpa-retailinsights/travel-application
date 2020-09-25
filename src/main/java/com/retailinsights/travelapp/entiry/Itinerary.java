package com.retailinsights.travelapp.entiry;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Itinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
    private String  status;
    private boolean is_active;
    private String source;
    private String destination;
    private String description;
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private  WishLists wishlist;
    private String start_date;
    private String end_date;
    private boolean is_confirmed;
    private int no_of_days;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "itinerary")
    private Bookings bookings;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "itinerary")
    private Enquiry enquiry;
    public Itinerary() {
		super();
	}

	public Itinerary(UUID id, String status, boolean isActive, String source, String destination, String description,
			WishLists wishlist, String startDate, String endDate, boolean isConfirmed, int noOfDays, Bookings bookings,
			Enquiry enquiry) {
		super();
		this.id = id;
		this.status = status;
		this.is_active = isActive;
		this.source = source;
		this.destination = destination;
		this.description = description;
		this.wishlist = wishlist;
		this.start_date = startDate;
		this.end_date = endDate;
		this.is_confirmed = isConfirmed;
		this.no_of_days = noOfDays;
		this.bookings = bookings;
		this.enquiry = enquiry;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isActive() {
		return is_active;
	}

	public void setActive(boolean isActive) {
		this.is_active = isActive;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WishLists getWishlist() {
		return wishlist;
	}

	public void setWishlist(WishLists wishlist) {
		this.wishlist = wishlist;
	}

	public String getStartDate() {
		return start_date;
	}

	public void setStartDate(String startDate) {
		this.start_date = startDate;
	}

	public String getEndDate() {
		return end_date;
	}

	public void setEndDate(String endDate) {
		this.end_date = endDate;
	}

	public boolean isConfirmed() {
		return is_confirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.is_confirmed = isConfirmed;
	}

	public int getNoOfDays() {
		return no_of_days;
	}

	public void setNoOfDays(int noOfDays) {
		this.no_of_days = noOfDays;
	}

	public Bookings getBookings() {
		return bookings;
	}

	public void setBookings(Bookings bookings) {
		this.bookings = bookings;
	}

	public Enquiry getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}

	
}
