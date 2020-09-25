package com.retailinsights.travelapp.entiry;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Admins {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String admin_name;
	private String company_name;
	private String email;
	private Timestamp registered_date;
	private String phone;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy="admin")
	private Set<Enquiry>enquiry;
	public Admins() {
		super();
	}

	public Admins(UUID id, String adminName, String companyName, String email, Timestamp registeredDate, String phone,
			Address address, Set<Enquiry> enquiry) {
		super();
		this.id = id;
		this.admin_name = adminName;
		this.company_name = companyName;
		this.email = email;
		this.registered_date = registeredDate;
		this.phone = phone;
		this.enquiry = enquiry;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String adminName) {
		this.admin_name = adminName;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String companyName) {
		this.company_name = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegisteredDate() {
		return registered_date;
	}

	public void setRegisteredDate(Timestamp registeredDate) {
		this.registered_date = registeredDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Enquiry> getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(Set<Enquiry> enquiry) {
		this.enquiry = enquiry;
	}

	
	
}
