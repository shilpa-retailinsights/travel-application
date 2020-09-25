package com.retailinsights.travelapp.model;

import java.util.UUID;

public class PaymentsFormDto {

	//private UUID id;
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
	
	private UUID student_id;

	/*
	 * public UUID getId() { return id; } public void setId(UUID id) { this.id = id;
	 * }
	 */
	public UUID getStudent_id() {
		return student_id;
	}
	public void setStudentId(UUID studentId) {
		this.student_id = studentId;
	}
	public boolean getSuccess() {
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
	public void setTransaction_id(int transactionId) {
		this.transaction_id = transactionId;
	}
	public String getPayment_method() {
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
	public String getUpdatedAt() {
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
	
	
}