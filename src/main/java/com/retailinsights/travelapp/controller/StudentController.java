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
import com.retailinsights.travelapp.entiry.Student;
import com.retailinsights.travelapp.model.StudentFormDto;
import com.retailinsights.travelapp.service.AddressService;
import com.retailinsights.travelapp.service.SchoolService;
import com.retailinsights.travelapp.service.StudentService;
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private SchoolService schoolService;
	@PostMapping("/api/v1/students")
	public ResponseEntity<Student> addStudentDetails(@RequestBody StudentFormDto studentDto) {
		Student student = new Student();
		Optional<Schools> school = schoolService.findSchoolById(studentDto.getSchool_id());
		Optional<Address> address = addressService.findById(studentDto.getAddress_id());
		student.setSchool(school.get());
		student.setAddress(address.get());
		//student.setId(studentDto.getId());
		student.setAge(studentDto.getAge());
		student.setFirstName(studentDto.getFirst_name());
		student.setLastName(studentDto.getLast_name());
		student.setEmail(studentDto.getEmail());
		student.setPhone(studentDto.getPhone());
		Student addedStudent = studentService.addStudentDetails(student);
		return new ResponseEntity<Student>(addedStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/api/v1/students/{studentId}")
	public Student findByStudentId(@PathVariable(name = "studentId") UUID studentId) {
		Optional<Student> student = studentService.findStudentById(studentId);
		return student.get();
	}
	
	@GetMapping("/api/v1/students")
	public List<Student> findAllStudents(){
		List<Student> studentList = studentService.findAllStudentdetails();
		return studentList;
	}
	
	@DeleteMapping("/api/v1/students/{studentId}")
	public ResponseEntity deleteStudent(@PathVariable(name = "studentId") UUID studentId) {
		studentService.deleteStudentDetails(studentId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	@PutMapping("/api/v1/students/{studentId}")
	public Student updatePaymentData(@RequestBody StudentFormDto studentDto,@PathVariable(name = "studentId") UUID studentId) {
		Optional<Student> studentData = studentService.findStudentById(studentId);
		studentData.get().setEmail(studentDto.getEmail());
		studentData.get().setFirstName(studentDto.getFirst_name());
		studentData.get().setLastName(studentDto.getLast_name());
		studentData.get().setPhone(studentDto.getPhone());
		Student updatedStudent = studentService.updateStudentDetails(studentData.get());
		return updatedStudent;
	}

}
