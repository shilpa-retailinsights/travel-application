package com.retailinsights.travelapp.controller;
import java.sql.Timestamp;
import java.util.Date;
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
import com.retailinsights.travelapp.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	@PostMapping("/api/v1/admins")
	public ResponseEntity<Admins> addAdminData(@RequestBody Admins admin) {
		admin.setRegisteredDate(new Timestamp(new Date().getTime()));
		Admins addedAdminData = adminService.addAdminData(admin);
		return new ResponseEntity<Admins>(addedAdminData,HttpStatus.CREATED);
	}
	
	@GetMapping("/api/v1/admins/{adminId}")
	public Optional<Admins> findByAdminId(@PathVariable(name = "adminId") UUID adminId) {
		Optional<Admins> adminData = adminService.findByAdminId(adminId);
		return adminData;
	}
	@GetMapping("/api/v1/admins")
	public List<Admins> findAllAdmins(){
		List<Admins> adminList = adminService.findAllAdmins();
		return adminList;
	}
	
	@DeleteMapping("/api/v1/admins/{adminId}")
	public ResponseEntity deleteAdminData(@PathVariable(name = "adminId") UUID adminId) {
		adminService.deleteAdminData(adminId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/api/v1/admins/{adminId}")
	public Admins updatedAdminData(@RequestBody Admins admin,@PathVariable(name = "adminId") UUID adminId) {
		Optional<Admins> adminData = adminService.findByAdminId(adminId);
		adminData.get().setAdmin_name(admin.getAdmin_name());
		adminData.get().setCompany_name(admin.getCompany_name());
		adminData.get().setEmail(admin.getEmail());
		adminData.get().setPhone(admin.getPhone());
		Admins updatedAdminData = adminService.updateAdminsData(adminData.get());
		return updatedAdminData;
	}
}
