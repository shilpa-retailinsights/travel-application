package com.retailinsights.travelapp.controller;
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

import com.retailinsights.travelapp.entiry.Bookings;
import com.retailinsights.travelapp.model.BookingsFormDto;
import com.retailinsights.travelapp.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	
	@PostMapping("/api/v1/bookings")
	public String  addBooking(@RequestBody BookingsFormDto bookingFormDto) {
		Bookings booking = bookingService.insertBookings(bookingFormDto);
		if(booking != null) {
			return "booking done";
		}
		else {
			return "booking failed";
		}
		
	}
	
	@GetMapping("/api/v1/bookings/{bookingId}")
	public Bookings findBookingById(@PathVariable(name = "bookingId") UUID bookingId) {
		Optional<Bookings> booking = bookingService.findByBookingId(bookingId);
		return booking.get();
	}
	
	@DeleteMapping("/api/v1/bookings/{bookingId}")
	public ResponseEntity deleteBooking(@PathVariable(name = "bookingId") UUID bookingId) {
		bookingService.deleteBooking(bookingId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	@PutMapping("/api/v1/bookings/{bookingId}")
	public String updateBooking(@PathVariable(name = "bookingId") UUID bookingId,@RequestBody BookingsFormDto bookingDto) {
		Bookings booking = bookingService.updateBookings(bookingDto,bookingId);
		if(booking !=null) {
			return "Booking Done";
		}
		else {
			return "booking failed";
		}
	}
}
 