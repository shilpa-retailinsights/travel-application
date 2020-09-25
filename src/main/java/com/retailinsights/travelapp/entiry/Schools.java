package com.retailinsights.travelapp.entiry;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;*/
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Schools {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String organizer_name;
	private int age;
	private String email;
	private String school_name;
	private String phone;
	@JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "school")
	private WishLists wishList;
   
	public WishLists getWishList() {
	return wishList;
    }

   public void setWishList(WishLists wishList) {
	this.wishList = wishList;
   }
    @JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "school")
	private Set<Student> students;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "school")
	private Set<Enquiry> enquiry;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "school")
	private Invoices invoices;
	
	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	/*
	 * @JoinTable(name = "package_school", joinColumns
	 * = @JoinColumn(name="school_id"), inverseJoinColumns
	 * = @JoinColumn(name="package_id"))
	 */
	//private Packages packages;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "school")
	private Bookings booking; 
	
	public Schools() {
		super();
	}

	

	public Schools(UUID id, String organizerName, int age, String email, String schoolName, String phone,
			WishLists wishList, Address address, Set<Student> students, Set<Enquiry> enquiry, Invoices invoices,
			 Bookings booking) {
		super();
		this.id = id;
		this.organizer_name = organizerName;
		this.age = age;
		this.email = email;
		this.school_name = schoolName;
		this.phone = phone;
		this.wishList = wishList;
		this.address = address;
		this.students = students;
		this.enquiry = enquiry;
		this.invoices = invoices;
		this.booking = booking;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getOrganizerName() {
		return organizer_name;
	}

	public void setOrganizerName(String organizerName) {
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

	public String getSchoolName() {
		return school_name;
	}

	public void setSchoolName(String schoolName) {
		this.school_name = schoolName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Enquiry> getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(Set<Enquiry> enquiry) {
		this.enquiry = enquiry;
	}

	public Invoices getInvoices() {
		return invoices;
	}

	public void setInvoices(Invoices invoices) {
		this.invoices = invoices;
	}


	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Schools [id=" + id + ", organizerName=" + organizer_name + ", age=" + age + ", email=" + email
				+ ", schoolName=" + school_name + ", phone=" + phone + ", wishList=" + wishList + ", address=" + address
				+ ", students=" + students + ", enquiry=" + enquiry + ", invoices=" + invoices + ", booking=" + booking
				+ "]";
	}

}
