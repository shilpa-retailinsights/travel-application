package com.retailinsights.travelapp.model;

import java.util.UUID;

public class HotelFormDto {
	private String name;
	private String check_in;
	private String check_out;
	private String image;
	private int room_num;
	private boolean is_active;
	private String room_details;
	private String status;
	private boolean is_confirmed;
	private UUID address_id;
	private int packages_id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCheck_in() {
		return check_in;
	}
	public void setCheck_in(String checkIn) {
		this.check_in = checkIn;
	}
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String checkOut) {
		this.check_out = checkOut;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getRoom_num() {
		return room_num;
	}
	public void setRoom_num(int roomNum) {
		this.room_num = roomNum;
	}
	public boolean getActive() {
		return is_active;
	}
	public void setActive(boolean isActive) {
		this.is_active = isActive;
	}
	public String getRoom_details() {
		return room_details;
	}
	public void setRoom_details(String roomDetails) {
		this.room_details = roomDetails;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean getConfirmed() {
		return is_confirmed;
	}
	public void setConfirmed(boolean isConfirmed) {
		this.is_confirmed = isConfirmed;
	}
	public UUID getAddress_id() {
		return address_id;
	}
	public void setAddress_id(UUID addressId) {
		this.address_id = addressId;
	}
	public int getPackages_id() {
		return packages_id;
	}
	public void setPackages_id(int packagesId) {
		this.packages_id = packagesId;
	}
	
}
