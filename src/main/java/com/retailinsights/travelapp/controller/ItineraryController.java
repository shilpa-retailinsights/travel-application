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

import com.retailinsights.travelapp.entiry.Itinerary;
import com.retailinsights.travelapp.entiry.WishLists;
import com.retailinsights.travelapp.model.ItineraryFormDto;
import com.retailinsights.travelapp.service.ItineraryService;
import com.retailinsights.travelapp.service.WishListService;

@RestController
public class ItineraryController {

	@Autowired 
	private WishListService wishListService;
	
	@Autowired
	private ItineraryService itineraryService;
	@PostMapping("/api/v1/itinerary")
	public ResponseEntity<Itinerary> addItinerary(@RequestBody ItineraryFormDto itineraryDto) {
		Optional<WishLists> wishlist = wishListService.findWishListById(itineraryDto.getWishlist_id());
		Itinerary itinerary = new Itinerary();
		itinerary.setWishlist(wishlist.get());
		itinerary.setActive(itineraryDto.getIs_active());
		itinerary.setSource(itineraryDto.getSource());
		itinerary.setDestination(itineraryDto.getDestination());
		itinerary.setConfirmed(itineraryDto.getIs_confirmed());
		itinerary.setDescription(itineraryDto.getDescription());
		itinerary.setStartDate(itineraryDto.getStart_date());
		itinerary.setNoOfDays(itineraryDto.getNo_of_days());
		itinerary.setEndDate(itineraryDto.getEnd_date());
		itinerary.setStatus(itineraryDto.getStatus());
		Itinerary addedItinerary = itineraryService.addItinerary(itinerary);
		return new ResponseEntity<Itinerary>(addedItinerary,HttpStatus.CREATED);
	}
	
	@GetMapping("/api/v1/itinerary")
	public List<Itinerary> findAllItinerary(){
		List<Itinerary> itineraryList = itineraryService.findAllItinerary();
		return itineraryList;
	}
	
	@GetMapping("/api/v1/itinerary/{itineraryId}")
	public Itinerary findItineraryById(@PathVariable(name = "itineraryId") UUID itineraryId) {
		Optional<Itinerary> itinerary = itineraryService.findItineraryById(itineraryId);
		return itinerary.get();
	}
	
	@DeleteMapping("/api/v1/itinerary/{itineraryId}")
	public ResponseEntity deleteItinerary(@PathVariable(name = "itineraryId") UUID itineraryId) {
		itineraryService.deleteItinerary(itineraryId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/api/v1/itinerary/{itineraryId}")
	public Itinerary updateItinerary(@RequestBody ItineraryFormDto itineraryFormDto ,@PathVariable(name = "itineraryId") UUID itineraryId) {
		Optional<Itinerary> itineraryData = itineraryService.findItineraryById(itineraryId);
		itineraryData.get().setDestination(itineraryFormDto.getDestination());
		itineraryData.get().setSource(itineraryFormDto.getSource());
		itineraryData.get().setStartDate(itineraryFormDto.getStart_date());
		itineraryData.get().setEndDate(itineraryFormDto.getEnd_date());
		itineraryData.get().setNoOfDays(itineraryFormDto.getNo_of_days());
		Itinerary updatedItinerary = itineraryService.updateItinerary(itineraryData.get());
		return updatedItinerary;
	}
}
