package com.retailinsights.travelapp.entiry;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Documents {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String name;
	private String uploaded_date;
	private int size;
	private String status;
	private String type;
	private String image;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Student student;

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

	public Documents(UUID id, String name, String uploaded_date, int size, String status, String type, String image,
			Student student) {
		super();
		this.id = id;
		this.name = name;
		this.uploaded_date = uploaded_date;
		this.size = size;
		this.status = status;
		this.type = type;
		this.image = image;
		this.student = student;
	}

	public String getUploaded_date() {
		return uploaded_date;
	}

	public void setUploaded_date(String uploaded_date) {
		this.uploaded_date = uploaded_date;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Documents() {
		super();
	}

}
