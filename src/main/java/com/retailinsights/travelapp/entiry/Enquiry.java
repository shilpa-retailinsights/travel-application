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
public class Enquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
    private String name;
    private String subject;
    private String query;
    private String reply;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Itinerary itinerary;
    
    public Itinerary getItinerary() {
		return itinerary;
	}
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Schools school;
	@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Admins admin;
    public Enquiry() {
		super();
	}
	
	public Enquiry(UUID id, String name, String subject, String query, String reply, Itinerary itinerary,
			Schools school, Admins admin) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.query = query;
		this.reply = reply;
		this.itinerary = itinerary;
		this.school = school;
		this.admin = admin;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Schools getSchool() {
		return school;
	}
	public void setSchool(Schools school) {
		this.school = school;
	}
	public Admins getAdmin() {
		return admin;
	}
	public void setAdmin(Admins admin) {
		this.admin = admin;
	}
	
}
