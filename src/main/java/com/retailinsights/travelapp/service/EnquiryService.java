package com.retailinsights.travelapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Enquiry;
import com.retailinsights.travelapp.repo.EnquiryRepository;

@Service
public class EnquiryService {

	@Autowired
	private EnquiryRepository enquiryRepository;
	
	public Enquiry addEnquiry(Enquiry enquiry) {
		return enquiryRepository.save(enquiry);
	}
	
	public List<Enquiry> findAllEnquiries(){
		List<Enquiry> enquiries = enquiryRepository.findAll();
		return enquiries;
	}
	
	public Optional<Enquiry> findEnquiryById(UUID enquiryId){
		Optional<Enquiry> enquiry = enquiryRepository.findById(enquiryId);
		return enquiry;
	}
	
	public void deleteEnquiry(UUID enquiryId) {
		enquiryRepository.deleteById(enquiryId);
	}
	
	public Enquiry updateEnquiry(Enquiry enquiry) {
		return enquiryRepository.save(enquiry);
	}
}
