package com.retailinsights.travelapp.entiry;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;*/
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Packages {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String type;
	private String location;
	private int price;
	private String creation_date;
	private int trip_code;
	private boolean availability;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "packages")
	private Hotels hotels;
	
	public Packages() {
		super();
	}

	public Packages(int id, String name, String type, String location, int price, String creationDate, int tripCode,
			boolean availability, Hotels hotels, WishLists wishlist, Bookings booking) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.location = location;
		this.price = price;
		this.creation_date = creationDate;
		this.trip_code = tripCode;
		this.availability = availability;
		this.hotels = hotels;
		//this.wishlist = wishlist;
		//this.booking = booking;
		//this.school = school;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(String creationDate) {
		this.creation_date = creationDate;
	}

	public int getTrip_code() {
		return trip_code;
	}

	public void setTrip_code(int tripCode) {
		this.trip_code = tripCode;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Hotels getHotels() {
		return hotels;
	}

	public void setHotels(Hotels hotels) {
		this.hotels = hotels;
	}
	
}
