package com.retailinsights.travelapp.model;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.retailinsights.travelapp.entiry.Itinerary;
import com.retailinsights.travelapp.entiry.Packages;
import com.retailinsights.travelapp.entiry.Schools;

public class WishListResponse {
	private UUID id;
	private String image;
	private boolean availability;
	private String packageIds;
	private List<Packages> pkgs;
	
	public String getPackageIds() {
		return packageIds;
	}

	public void setPackageIds(String packageIds) {
		this.packageIds = packageIds;
	}
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "wishlist")
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
	/*
	 * @JsonIgnore
	 * 
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy =
	 * "wishlist") private Set<Packages> packages;
	 */

	public WishListResponse() {
		super();
	}


	public UUID getId() {
		return id;
	}

	public WishListResponse(UUID id, String image, boolean availability, String packageIds, List<Packages> pkgs,
			Set<Itinerary> itinerary, Schools school) {
		super();
		this.id = id;
		this.image = image;
		this.availability = availability;
		this.packageIds = packageIds;
		this.pkgs = pkgs;
		this.itinerary = itinerary;
		this.school = school;
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

	public List<Packages> getPkgs() {
		return pkgs;
	}

	public void setPkgs(List<Packages> pkgs) {
		this.pkgs = pkgs;
	}
}
