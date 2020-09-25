package com.retailinsights.travelapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Hotels;
import com.retailinsights.travelapp.repo.HotelsRepository;

@Service
public class HotelService {

	@Autowired
	private HotelsRepository hotelsRepository;
	
	public Hotels addHotel(Hotels hotels) {
		return hotelsRepository.save(hotels);
	}
	
	public List<Hotels> findAllHotels(){
		return hotelsRepository.findAll();
	}
	
	public Optional<Hotels> findHotelById(UUID hotelId){
		Optional<Hotels> hotelData = hotelsRepository.findById(hotelId);
		return hotelData;
	}
	
	public void deleteHotel(UUID hotelId) {
		hotelsRepository.deleteById(hotelId);
	}
	
	public Hotels updatedHotel(Hotels hotel) {
		return hotelsRepository.save(hotel);
		
	}
}
