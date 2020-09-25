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
public class Hotels {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String name;
	private String  check_in;
	private String check_out; 
	private String image;
	private int room_num;
	private boolean is_active;
	private String room_details;
	private String status;
	private boolean is_confirmed;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Address address;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Packages packages;
	public Hotels() {
		super();
	}

	public Hotels(UUID id, String name, String checkIn, String checkOut, String image, int roomNum, boolean isActive,
			String roomDetails, String status, boolean isConfirmed, Address address, Packages packages) {
		super();
		this.id = id;
		this.name = name;
		this.check_in = checkIn;
		this.check_out = checkOut;
		this.image = image;
		this.room_num = roomNum;
		this.is_active = isActive;
		this.room_details = roomDetails;
		this.status = status;
		this.is_confirmed = isConfirmed;
		this.address = address;
		this.packages = packages;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCheckIn() {
		return check_in;
	}

	public void setCheckIn(String checkIn) {
		this.check_in = checkIn;
	}

	public String getCheckOut() {
		return check_out;
	}

	public void setCheckOut(String checkOut) {
		this.check_out = checkOut;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRoomNum() {
		return room_num;
	}

	public void setRoomNum(int roomNum) {
		this.room_num = roomNum;
	}

	public boolean isActive() {
		return is_active;
	}

	public void setActive(boolean isActive) {
		this.is_active = isActive;
	}

	public String getRoomDetails() {
		return room_details;
	}

	public void setRoomDetails(String roomDetails) {
		this.room_details = roomDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isConfirmed() {
		return is_confirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.is_confirmed = isConfirmed;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	
	
}
