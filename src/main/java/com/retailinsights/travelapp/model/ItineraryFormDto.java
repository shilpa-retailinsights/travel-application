package com.retailinsights.travelapp.model;

import java.util.UUID;
public class ItineraryFormDto {
	private UUID wishlist_id;
	private String status;
	private boolean is_active;
	private String source;
	private String destination;
	private String description;
	private String start_date;
	private String end_date;
	private boolean is_confirmed;
	private int no_of_days;
	
	public UUID getWishlist_id() {
		return wishlist_id;
	}
	public void setWishlist_id(UUID wishlistId) {
		this.wishlist_id = wishlistId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean getIs_active() {
		return is_active;
	}
	public void setIs_active(boolean isActive) {
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
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String startDate) {
		this.start_date = startDate;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String endDate) {
		this.end_date = endDate;
	}
	public boolean getIs_confirmed() {
		return is_confirmed;
	}
	public void setIs_confirmed(boolean isConfirmed) {
		this.is_confirmed = isConfirmed;
	}
	public int getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(int noOfDays) {
		this.no_of_days = noOfDays;
	}
	
}
