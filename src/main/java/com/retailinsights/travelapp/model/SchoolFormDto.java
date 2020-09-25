package com.retailinsights.travelapp.model;

import java.util.UUID;

public class SchoolFormDto {

	private UUID address_id;
	private String organizer_name;
	private int age;
	private String email;
	private String school_name;
	private String phone;
	
	public UUID getAddress_id() {
		return address_id;
	}
	public void setAddressId(UUID addressId) {
		this.address_id = addressId;
	}
	public String getOrganizer_name() {
		return organizer_name;
	}
	public void setOrganizer_name(String organizerName) {
		this.organizer_name = organizerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String schoolName) {
		this.school_name = schoolName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
