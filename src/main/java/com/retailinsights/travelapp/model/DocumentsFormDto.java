package com.retailinsights.travelapp.model;

import java.util.UUID;

public class DocumentsFormDto {

	 private UUID student_id;
	 private String name;
	 private String uploaded_date;
	 private int size;
	 private String status;
	 private String type;
	 private String image;
	
	public UUID getStudent_id() {
		return student_id;
	}
	public void setStudent_id(UUID studentId) {
		this.student_id = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUploaded_date() {
		return uploaded_date;
	}
	public void setUploaded_date(String uploadedDate) {
		this.uploaded_date = uploadedDate;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
