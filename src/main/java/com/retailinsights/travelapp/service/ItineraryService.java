package com.retailinsights.travelapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Itinerary;
import com.retailinsights.travelapp.repo.ItineraryRepository;

@Service
public class ItineraryService {

	@Autowired
	private ItineraryRepository itineraryRepository;
	
	public Itinerary addItinerary(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}
	
	public List<Itinerary> findAllItinerary(){
		return itineraryRepository.findAll();
	}
	
	public Optional<Itinerary> findItineraryById(UUID itineraryId){
		Optional<Itinerary> itineraryData = itineraryRepository.findById(itineraryId);
		return itineraryData;
	}
	
	public void deleteItinerary(UUID itineraryId) {
		itineraryRepository.deleteById(itineraryId);
	}
	
	public Itinerary updateItinerary(Itinerary itinerary) {
		return itineraryRepository.save(itinerary);
	}
}
