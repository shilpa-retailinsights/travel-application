package com.retailinsights.travelapp.entiry;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String from_date;
	private String to_date;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	//private boolean is_confirmed;
	private boolean is_paid;
	
	
	

	public boolean isPaid() {
		return is_paid;
	}

	public void setPaid(boolean isPaid) {
		this.is_paid = isPaid;
	}

	public int getTripCode() {
		return tripCode;
	}

	public void setTripCode(int tripCode) {
		this.tripCode = tripCode;
	}

	private int tripCode;
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	//@JsonIgnoreProperties("notifications")
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Payments payments;
    
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "booking")
	private Invoices invoice;
    
    public Bookings(UUID id, String from_date, String to_date,  boolean is_confirmed,
			boolean is_paid, String status, int tripCode, Payments payments, Invoices invoice, Schools school,
			Itinerary itinerary) {
		super();
		this.id = id;
		this.from_date = from_date;
		this.to_date = to_date;
		//this.is_confirmed = is_confirmed;
		this.is_paid = is_paid;
		this.status = status;
		this.tripCode = tripCode;
		this.payments = payments;
		this.invoice = invoice;
		this.school = school;
		this.itinerary = itinerary;
	}

	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Schools school; 
    
    @OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Itinerary itinerary;
	
	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	public Bookings() {
		super();
	}


	public UUID getId() {
		return id;
	}

	
	public void setId(UUID id) {
		this.id = id;
	}

	public String getFromDate() {
		return from_date;
	}

	public void setFromDate(String fromDate) {
		this.from_date = fromDate;
	}

	public String getToDate() {
		return to_date;
	}

	public void setToDate(String toDate) {
		this.to_date = toDate;
	}

	/*
	 * public boolean isConfirmed() { return is_confirmed; }
	 * 
	 * public void setConfirmed(boolean isConfirmed) { this.is_confirmed =
	 * isConfirmed; }
	 */

	
	public Payments getPayments() {
		return payments;
	}

	public void setPayments(Payments payments) {
		this.payments = payments;
	}

	public Invoices getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoices invoice) {
		this.invoice = invoice;
	}

	public Schools getSchool() {
		return school;
	}

	public void setSchool(Schools school) {
		this.school = school;
	}

	
	
}
