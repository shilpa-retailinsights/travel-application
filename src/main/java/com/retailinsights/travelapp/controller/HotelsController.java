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
import com.retailinsights.travelapp.entiry.Hotels;
import com.retailinsights.travelapp.entiry.Packages;
import com.retailinsights.travelapp.model.HotelFormDto;
import com.retailinsights.travelapp.service.AddressService;
import com.retailinsights.travelapp.service.HotelService;
import com.retailinsights.travelapp.service.PackageService;

@RestController
public class HotelsController {

	@Autowired
	private PackageService packageService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/api/v1/hotels")
	public ResponseEntity<Hotels> addHotels(@RequestBody HotelFormDto hotelDto) {
		Hotels hotel = new Hotels();
		Optional<Address> address = addressService.findById(hotelDto.getAddress_id());
		Optional<Packages> packages = packageService.findbyPackageId(hotelDto.getPackages_id());
		hotel.setAddress(address.get());
		hotel.setPackages(packages.get());
		hotel.setName(hotelDto.getName());
		hotel.setActive(hotelDto.getActive());
		hotel.setCheckIn(hotelDto.getCheck_in());
		hotel.setCheckOut(hotelDto.getCheck_out());
		hotel.setConfirmed(hotelDto.getConfirmed());
		hotel.setImage(hotelDto.getImage());
		hotel.setRoomDetails(hotelDto.getRoom_details());
		hotel.setRoomNum(hotelDto.getRoom_num());
		hotel.setStatus(hotelDto.getStatus());
		Hotels addedHotel = hotelService.addHotel(hotel);
		return new ResponseEntity<Hotels>(addedHotel,HttpStatus.CREATED);
	}
	
	@GetMapping("/api/v1/hotels")
	public List<Hotels> findallHotels(){
		List<Hotels> hotelList = hotelService.findAllHotels();
		return hotelList;
	}
	
	@GetMapping("/api/v1/hotels/{hotelId}")
	public Hotels findHotelById(@PathVariable(name = "hotelId")UUID hotelId) {
		Optional<Hotels> hotel = hotelService.findHotelById(hotelId);
		return hotel.get();
		
	}
	
	@DeleteMapping("/api/v1/hotels/{hotelId}")
	public ResponseEntity deleteHotel(@PathVariable(name = "hotelId")UUID hotelId) {
		hotelService.deleteHotel(hotelId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/api/v1/hotels/{hotelId}")
	public Hotels updateHotel(@RequestBody HotelFormDto hotelDto, @PathVariable(name = "hotelId")UUID hotelId) {
		Optional<Hotels> hotels = hotelService.findHotelById(hotelId);
		hotels.get().setCheckIn(hotelDto.getCheck_in());
		hotels.get().setCheckOut(hotelDto.getCheck_out());
		hotels.get().setImage(hotelDto.getImage());
		hotels.get().setName(hotelDto.getName());
		Hotels updatedHotel = hotelService.updatedHotel(hotels.get());
		return updatedHotel;
	}
}
