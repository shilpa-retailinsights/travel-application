package com.retailinsights.travelapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailinsights.travelapp.entiry.Packages;
import com.retailinsights.travelapp.service.PackageService;

@RestController
public class PackageController {

	@Autowired
	private PackageService packageService;
	
	@PostMapping("/api/v1/packages")
	public ResponseEntity<Packages> addPackage(@RequestBody Packages packages) {
		Packages packagesData = packageService.addPackages(packages);
		return new ResponseEntity<Packages>(packagesData,HttpStatus.CREATED);
	}
	
	@GetMapping("/api/v1/packages")
	public List<Packages> findAllPackages(){
		List<Packages> packagesList = packageService.findAllPackages();
		return packagesList;
	}
	@GetMapping("/api/v1/packages/{packageId}")
	public Packages findPackageById(@PathVariable(name = "packageId") int packageId) {
		Optional<Packages> packageData = packageService.findbyPackageId(packageId);
		return packageData.get();
	}
	
	@DeleteMapping("/api/v1/packages/{packageId}")
	public ResponseEntity deleteByPackageId(@PathVariable(name = "packageId") int packageId) {
		packageService.deletePackage(packageId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/api/v1/packages/{packageId}")
	public Packages updatePackageData(@RequestBody Packages packages,@PathVariable(name = "packageId") int packageId) {
		Optional<Packages> packageData = packageService.findbyPackageId(packageId);
		packageData.get().setCreation_date(packages.getCreation_date());
		packageData.get().setName(packages.getName());
		packageData.get().setTrip_code(packages.getTrip_code());
		Packages updatePackage = packageService.updatePackage(packageData.get());
		return updatePackage;
	}
}
