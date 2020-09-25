package com.retailinsights.travelapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Student;
import com.retailinsights.travelapp.repo.StudentRepository;
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student addStudentDetails(Student student) {
		return studentRepository.save(student);
	}
	
	public Optional<Student> findStudentById(UUID id){
		return studentRepository.findById(id);
	}
	
	public List<Student> findAllStudentdetails(){
		return studentRepository.findAll();
	}
	
	public void deleteStudentDetails(UUID id) {
		studentRepository.deleteById(id);
	}
	
	public Student updateStudentDetails(Student student) {
		return studentRepository.save(student);
	}
}
