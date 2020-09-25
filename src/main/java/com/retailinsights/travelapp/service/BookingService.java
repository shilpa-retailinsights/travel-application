package com.retailinsights.travelapp.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Bookings;
import com.retailinsights.travelapp.entiry.Itinerary;
import com.retailinsights.travelapp.entiry.Payments;
import com.retailinsights.travelapp.entiry.Schools;
import com.retailinsights.travelapp.model.BookingsFormDto;
import com.retailinsights.travelapp.repo.BookingsRepository;

@Service
public class BookingService {

	@Autowired
	private BookingsRepository bookingRepository;
	
	@Autowired
	private MailServiceImpl mailService;
	
	@Autowired
	private ItineraryService itineraryService;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private PaymentService paymentService;
	
	public Bookings insertBookings(BookingsFormDto bookingFormDto) {
		Optional<Payments> payment = paymentService.findByPaymentId(bookingFormDto.getPayments_id());
		Optional<Schools> school = schoolService.findSchoolById(bookingFormDto.getSchool_id());
		Optional<Itinerary> itinerary = itineraryService.findItineraryById(bookingFormDto.getItinerary_id());
		//Optional<Status> status = statusService.findById(bookingFormDto.getStatus_id());
		Bookings booking = new Bookings();
		booking.setItinerary(itinerary.get());
		booking.setPayments(payment.get());
		booking.setSchool(school.get());
		booking.setFromDate(bookingFormDto.getFrom_date());
		booking.setPaid(bookingFormDto.getIs_paid());
		booking.setToDate(bookingFormDto.getTo_date());
		booking.setTripCode(bookingFormDto.getTrip_code());
		booking.setStatus(bookingFormDto.getStatus());
		Bookings addedBookings = bookingRepository.save(booking);
		if(addedBookings !=null) {
			String content = "Your Trip Code  "+addedBookings.getTripCode()+" for the school "+addedBookings.getSchool().getSchoolName()+" is successfully booked";
			String subject = "Trip Code "+addedBookings.getTripCode()+" "+addedBookings.getStatus();
			mailService.sendMail(bookingFormDto.getTo_address(), bookingFormDto.getFrom_address(), subject, content);
		}
		else {
			String content = "Sorry Your Booking Not Confirmed ";
			String subject = "Booking Failed";
			mailService.sendMail(bookingFormDto.getTo_address(), bookingFormDto.getFrom_address(), subject, content);
		}
		return addedBookings;
	}
	
	public List<Bookings> findAllBookings(){
		List<Bookings> bookingList = bookingRepository.findAll();
		return bookingList;
	}
	
	public Optional<Bookings> findByBookingId(UUID bookingId){
		Optional<Bookings> booking = bookingRepository.findById(bookingId);
		return booking;
	}
	
	public void deleteBooking(UUID bookingId) {
		bookingRepository.deleteById(bookingId);
	}
	
	/*
	 * public Bookings updateBookings(Bookings booking) { return
	 * bookingRepository.save(booking); }
	 */

	public Bookings updateBookings(BookingsFormDto bookingDto, UUID bookingId) {
		Optional<Bookings> bookings = bookingRepository.findById(bookingId);
		//Optional<Status> status = statusService.findById(bookingDto.getStatus_id());
		bookings.get().setFromDate(bookingDto.getFrom_date());
		bookings.get().setToDate(bookingDto.getTo_date());
		bookings.get().setTripCode(bookingDto.getTrip_code());
		bookings.get().setStatus(bookingDto.getStatus());
		Bookings updatedbooking = bookingRepository.save(bookings.get());
		if(updatedbooking !=null) {
			String content = "Your Booking No is "+updatedbooking.getTripCode()+" for the school "+updatedbooking.getSchool().getSchoolName()+" is "+updatedbooking.getStatus();
			String subject = "Trip Code "+updatedbooking.getTripCode()+" "+updatedbooking.getStatus();
			mailService.sendMail(bookingDto.getTo_address(), bookingDto.getFrom_address(), subject, content);
		}
		else {
			String content = "Sorry Your Booking Not Confirmed ";
			String subject = "Booking Failed";
			mailService.sendMail(bookingDto.getTo_address(), bookingDto.getFrom_address(), subject, content);
		}
		return updatedbooking;
	}
}
