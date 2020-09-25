package com.retailinsights.travelapp.model;
import java.util.Set;
import java.util.UUID;

import com.retailinsights.travelapp.entiry.Packages;
public class WishListFormDto {
	
	private String image;
	private boolean availability;
	private UUID school_id;
	private Set<Packages> packages;
	private Set<Integer> package_id;
	//private Set<Integer> packages_id;
	
	/*
	 * public Set<Integer> getPackages_id() { return packages_id; } public void
	 * setPackages_id(Set<Integer> packages_id) { this.packages_id = packages_id; }
	 */
	private String identifier;
	public Set<Integer> getPackage_id() {
		return package_id;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public void setPackage_id(Set<Integer> package_id) {
		this.package_id = package_id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	public UUID getSchool_id() {
		return school_id;
	}
	public void setSchool_id(UUID school_id) {
		this.school_id = school_id;
	}
	public Set<Packages> getPackages() {
		return packages;
	}
	public void setPackages(Set<Packages> packages) {
		this.packages = packages;
	}
	
}

/*
 * for(packages packages:packagesList) { 
 * wishlist w = new wishlist()
 * w.set(image(dto.getImage()))
 *  w.setPackageId(dto.getpackageId());
 * w.setSchoolId(dto.getSchoolId())
 *  wishRepo.save(w) }
 */
