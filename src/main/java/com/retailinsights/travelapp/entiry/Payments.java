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
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private boolean is_success;
	private String initiated_amount;
	private String payment_status;
	private int total_amount;
	private int transaction_id;
	private String payment_method;
	private String updated_by;
	private String created_by;
	private String updated_at;
	private String created_at;
	private boolean is_confirmed;
	private boolean is_active;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Student student;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "payments")
	private Bookings booking;
	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}


	public boolean isSuccess() {
		return is_success;
	}

	public void setSuccess(boolean isSuccess) {
		this.is_success = isSuccess;
	}

	public String getInitiated_amount() {
		return initiated_amount;
	}

	public void setInitiated_amount(String initiatedAmount) {
		this.initiated_amount = initiatedAmount;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String paymentStatus) {
		this.payment_status = paymentStatus;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int totalAmount) {
		this.total_amount = totalAmount;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransactionId(int transactionId) {
		this.transaction_id = transactionId;
	}

	public String getPaymentMethod() {
		return payment_method;
	}

	public void setPayment_method(String paymentMethod) {
		this.payment_method = paymentMethod;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updatedBy) {
		this.updated_by = updatedBy;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String createdBy) {
		this.created_by = createdBy;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updatedAt) {
		this.updated_at = updatedAt;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String createdAt) {
		this.created_at = createdAt;
	}

	public boolean getConfirmed() {
		return is_confirmed;
	}

	public void setConfirmed(boolean isConfirmed) {
		this.is_confirmed = isConfirmed;
	}

	public boolean getActive() {
		return is_active;
	}

	public void setActive(boolean isActive) {
		this.is_active = isActive;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payments(UUID id, boolean isSuccess, String initiatedAmount, String paymentStatus,
			int totalAmount, int transactionId, String paymentMethod, String updatedBy, String createdBy,
			String updatedAt, String createdAt, boolean isConfirmed, boolean isActive, Student student,
			Bookings booking) {
		super();
		this.id = id;
		this.is_success = isSuccess;
		this.initiated_amount = initiatedAmount;
		this.payment_status = paymentStatus;
		this.total_amount = totalAmount;
		this.transaction_id = transactionId;
		this.payment_method = paymentMethod;
		this.updated_by = updatedBy;
		this.created_by = createdBy;
		this.updated_at = updatedAt;
		this.created_at = createdAt;
		this.is_confirmed = isConfirmed;
		this.is_active = isActive;
		this.student = student;
		this.booking = booking;
	}

	
}
