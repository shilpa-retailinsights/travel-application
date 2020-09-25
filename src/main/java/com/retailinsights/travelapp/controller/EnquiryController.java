package com.retailinsights.travelapp.controller;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

import com.retailinsights.travelapp.entiry.Admins;
import com.retailinsights.travelapp.entiry.Enquiry;
import com.retailinsights.travelapp.entiry.Itinerary;
import com.retailinsights.travelapp.entiry.Schools;
import com.retailinsights.travelapp.model.EnquiryFormDto;
import com.retailinsights.travelapp.service.AdminService;
import com.retailinsights.travelapp.service.EnquiryService;
import com.retailinsights.travelapp.service.ItineraryService;
import com.retailinsights.travelapp.service.SchoolService;

@RestController
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;
	@Autowired
	private AdminService adminsservice;
	@Autowired
	private ItineraryService itineraryService;
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping("/api/v1/enquiry")
	public ResponseEntity<Enquiry> addEnquiry(@RequestBody EnquiryFormDto enquirydto) {
		Optional<Schools> school = schoolService.findSchoolById(enquirydto.getSchool_id());
		Optional<Itinerary> itinerary = itineraryService.findItineraryById(enquirydto.getItinerary_id());
		Optional<Admins> admin = adminsservice.findByAdminId(enquirydto.getAdmin_id());
		Enquiry enquiry = new Enquiry();
		enquiry.setSchool(school.get());
		enquiry.setItinerary(itinerary.get());
		enquiry.setAdmin(admin.get());
		enquiry.setName(enquirydto.getName());
		enquiry.setQuery(enquirydto.getQuery());
		enquiry.setReply(enquirydto.getReply());
		enquiry.setSubject(enquirydto.getSubject());
		Enquiry addedEnquiry = enquiryService.addEnquiry(enquiry);
		return new ResponseEntity<Enquiry>(addedEnquiry,HttpStatus.CREATED);
	}
	@GetMapping("/api/v1/enquiry")
	public List<Enquiry> findAllEnquiry(){
		List<Enquiry> enquiryList = enquiryService.findAllEnquiries();
		return enquiryList;
	}
	
	@GetMapping("/api/v1/enquiry/{enquiryId}")
	public Enquiry findEnquiryById(@PathVariable(name = "enquiryId")UUID enquiryId) {
		Optional<Enquiry> enquiry = enquiryService.findEnquiryById(enquiryId);
		return enquiry.get();
	}
	@DeleteMapping("/api/v1/enquiry/{enquiryId}")
	public ResponseEntity deleteEnquiry(@PathVariable(name = "enquiryId")UUID enquiryId) {
		enquiryService.deleteEnquiry(enquiryId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/api/v1/enquiry/{enquiryId}")
	public Enquiry updateEnquiry(@PathVariable(name = "enquiryId")UUID enquiryId, @RequestBody EnquiryFormDto enquiryDto) {
		Optional<Enquiry> enquiryData = enquiryService.findEnquiryById(enquiryId);
		enquiryData.get().setName(enquiryDto.getName());
		enquiryData.get().setQuery(enquiryDto.getQuery());
		Enquiry updatedEnquiry = enquiryService.updateEnquiry(enquiryData.get());
		return updatedEnquiry;
	}
}
