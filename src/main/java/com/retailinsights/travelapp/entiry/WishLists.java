package com.retailinsights.travelapp.entiry;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class WishLists {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String image;
	private boolean availability;
	//private int package_id;
	private String package_ids;
    private String identifier;
	public String getIdentifier() {
		return identifier;
	}

	public WishLists(UUID id, String image, boolean availability, int package_id, String package_ids, String identifier,
			Set<Itinerary> itinerary, Schools school) {
		super();
		this.id = id;
		this.image = image;
		this.availability = availability;
		//this.package_id = package_id;
		this.package_ids = package_ids;
		this.identifier = identifier;
		this.itinerary = itinerary;
		this.school = school;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/*
	 * public int getPackage_id() { return package_id; }
	 * 
	 * public void setPackage_id(int package_id) { this.package_id = package_id; }
	 * 
	 */
	public String getPackageIds() {
		return package_ids;
	}

	public void setPackageIds(String packageIds) {
		this.package_ids = packageIds;
	}
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "wishlist")
	private Set<Itinerary> itinerary;
	
	public Set<Itinerary> getItinerary() {
		return itinerary;
	}

	public void setItinerary(Set<Itinerary> itinerary) {
		this.itinerary = itinerary;
	}
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Schools school;
	
	public Schools getSchool() {
		return school;
	}

	public void setSchool(Schools school) {
		this.school = school;
	}
	
	public WishLists() {
		super();
	}


	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
}
