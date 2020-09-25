package com.retailinsights.travelapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Packages;
import com.retailinsights.travelapp.repo.PackagesRepository;

@Service
public class PackageService {

	@Autowired
	private PackagesRepository packagesRepository;
	
	public Packages addPackages(Packages packages) {
		Packages packagesData = packagesRepository.save(packages);
		return packagesData;
	}
	
	public List<Packages> findAllPackages(){
		List<Packages> packageList = packagesRepository.findAll();
		return packageList;
	}
	
	public Optional<Packages> findbyPackageId(int packageId){
		Optional<Packages> packageData = packagesRepository.findById(packageId);
		return packageData;
	}
	
	public Packages updatePackage(Packages packages) {
		Packages updatedPackage = packagesRepository.save(packages); 
		return updatedPackage;
	}
	
	public void deletePackage(int packageId) {
		packagesRepository.deleteById(packageId);
	}
}
