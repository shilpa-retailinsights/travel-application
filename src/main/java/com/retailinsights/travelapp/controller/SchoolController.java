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

import com.retailinsights.travelapp.entiry.Address;
import com.retailinsights.travelapp.entiry.Schools;
import com.retailinsights.travelapp.model.SchoolFormDto;
import com.retailinsights.travelapp.service.AddressService;
import com.retailinsights.travelapp.service.SchoolService;

@RestController
public class SchoolController {

	@Autowired
	private SchoolService schoolService;
	
	@Autowired 
	private AddressService addressService;
	
	@PostMapping("/api/v1/schools")
	public ResponseEntity<Schools> addSchoolData(@RequestBody SchoolFormDto schoolsDto) {
		Optional<Address> addAddress = addressService.findById(schoolsDto.getAddress_id());
		Schools school = new Schools();
		//school.setId(schoolsDto.getId());
		school.setAddress(addAddress.get());
		school.setAge(schoolsDto.getAge());
        school.setEmail(schoolsDto.getEmail());
        school.setOrganizerName(schoolsDto.getOrganizer_name());
        school.setPhone(schoolsDto.getPhone());
        school.setSchoolName(schoolsDto.getSchool_name());
		Schools addedschoolsData = schoolService.addSchools(school);
		return new ResponseEntity<Schools>(addedschoolsData,HttpStatus.CREATED);
	}
	@GetMapping("/api/v1/schools")
	public List<Schools> findAllSchools(){
		List<Schools> schoolsList = schoolService.findAllSchools();
		return schoolsList;
	}
	@GetMapping("/api/v1/schools/{schoolId}")
	public Schools findSchoolById(@PathVariable(name = "schoolId") UUID schoolId) {
		Optional<Schools> school = schoolService.findSchoolById(schoolId);
		return school.get();
	}
	
	@DeleteMapping("/api/v1/schools/{schoolId}")
	public ResponseEntity deleteStudentData(@PathVariable("schoolId") UUID schoolId) {
		 schoolService.deleteById(schoolId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/api/v1/schools/{schoolId}")
	public Schools updateSchoolsData(@RequestBody SchoolFormDto schoolDto, @PathVariable(name = "schoolId") UUID schoolId) {
		Optional<Schools> schoolData = schoolService.findSchoolById(schoolId);
		schoolData.get().setEmail(schoolDto.getEmail());
		schoolData.get().setOrganizerName(schoolDto.getOrganizer_name());
		schoolData.get().setPhone(schoolDto.getOrganizer_name());
		schoolData.get().setSchoolName(schoolDto.getSchool_name());
		Schools updatedSchool = schoolService.updateSchoolData(schoolData.get());
		return updatedSchool;
	}
}
