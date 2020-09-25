package com.retailinsights.travelapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Schools;
import com.retailinsights.travelapp.repo.SchoolsRepository;

@Service
public class SchoolService {

	@Autowired
	private SchoolsRepository schoolsRepository;
	
	public Schools addSchools(Schools school) {
		return schoolsRepository.save(school);
	}

	public List<Schools> findAllSchools() {
		return schoolsRepository.findAll();
	}
	
	public Optional<Schools> findSchoolById(UUID schoolId){
		Optional<Schools> school = schoolsRepository.findById(schoolId);
		return school;
	}
	
	public void deleteById(UUID schoolId) {
		schoolsRepository.deleteById(schoolId);
	}
	
	public Schools updateSchoolData(Schools school) {
		Schools schoolData = schoolsRepository.save(school);
		return schoolData;
	}
}
