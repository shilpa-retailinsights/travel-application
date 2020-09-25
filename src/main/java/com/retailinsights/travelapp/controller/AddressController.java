package com.retailinsights.travelapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailinsights.travelapp.entiry.Address;
import com.retailinsights.travelapp.service.AddressService;

@RestController
@CrossOrigin(origins = "*")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/api/v1/addresses")
	public ResponseEntity<Address> addAddress(@RequestBody Address address) {
		Address addedAddressDetails = addressService.addAddress(address);
		return new ResponseEntity<Address>(addedAddressDetails,HttpStatus.CREATED);
	}

	@GetMapping("/api/v1/addresses/{addressId}")
	public Optional<Address> findAddressById(@PathVariable(name = "addressId") UUID addressId){
		return addressService.findById(addressId);
	}
	
	@GetMapping("/api/v1/addresses")
	public List<Address> findAllAddresses(){
		return addressService.findAllAddresses();
	}
	
	@DeleteMapping("/api/v1/addresses/{addressId}")
	public ResponseEntity<String> deleteAddress(@PathVariable(name = "addressId") UUID addressId) {
		addressService.deleteAddress(addressId);
		return new ResponseEntity<String>("address deleted",HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/api/v1/addresses/{addressId}")
	public Address updateAddress(@PathVariable(name = "addressId") UUID addressId, @RequestBody Address address) {
		Optional<Address> addressData = addressService.findById(addressId);
		addressData.get().setCity(address.getCity());
		addressData.get().setCountry(address.getCountry());
		addressData.get().setLine1(address.getLine1());
		addressData.get().setLine2(address.getLine2());
		addressData.get().setPincode(address.getPincode());
		addressData.get().setState(address.getState());
		Address updateAddress = addressService.updateAddress(addressData.get());
		return updateAddress;
	}
}



