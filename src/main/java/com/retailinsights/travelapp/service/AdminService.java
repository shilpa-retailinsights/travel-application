package com.retailinsights.travelapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Admins;
import com.retailinsights.travelapp.repo.AdminsRepository;

@Service
public class AdminService {

	@Autowired
	private AdminsRepository adminsRepository;
	
	public Admins addAdminData(Admins admin) {
		return adminsRepository.save(admin);
	}
	
	public Optional<Admins> findByAdminId(UUID id){
		return adminsRepository.findById(id);
	}
	
	public List<Admins> findAllAdmins(){
		return adminsRepository.findAll();
	}
	
	public void deleteAdminData(UUID adminId) {
		adminsRepository.deleteById(adminId);
	}
	
	public Admins updateAdminsData(Admins admin) {
		return adminsRepository.save(admin);
	}
}
