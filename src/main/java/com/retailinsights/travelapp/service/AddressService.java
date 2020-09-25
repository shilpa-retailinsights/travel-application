package com.retailinsights.travelapp.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Address;
import com.retailinsights.travelapp.repo.AddressRepository;
@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public Address addAddress(Address address) {
		return addressRepository.save(address);
	}
	
	public Optional<Address> findById(UUID id){
		return addressRepository.findById(id);
	}
	
	public List<Address> findAllAddresses(){
		return addressRepository.findAll();
	}	
	
	public void deleteAddress(UUID deleteId) {
		addressRepository.deleteById(deleteId);
	}
	
	public Address updateAddress(Address address) {
		return addressRepository.save(address);
	}
}
