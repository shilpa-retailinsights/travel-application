package com.retailinsights.travelapp.model;
import java.util.UUID;
public class StudentFormDto {
	//private UUID Id;
	private String first_name;
	private String last_name;
	private int age;
	private String phone;
	private String email;
	private UUID address_id;
	private UUID school_id;

	/*
	 * public UUID getId() { return Id; } public void setId(UUID id) { Id = id; }
	 */
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String firstName) {
		this.first_name = firstName;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String lastName) {
		this.last_name = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UUID getAddress_id() {
		return address_id;
	}
	public void setAddressId(UUID addressId) {
		this.address_id = addressId;
	}
	public UUID getSchool_id() {
		return school_id;
	}
	public void setSchoolId(UUID schoolId) {
		this.school_id = schoolId;
	}
	
	
}
