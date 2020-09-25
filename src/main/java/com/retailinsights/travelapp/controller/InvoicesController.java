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
import com.retailinsights.travelapp.entiry.Bookings;
import com.retailinsights.travelapp.entiry.Invoices;
import com.retailinsights.travelapp.entiry.Schools;
import com.retailinsights.travelapp.model.InvoicesFormDto;
import com.retailinsights.travelapp.service.AddressService;
import com.retailinsights.travelapp.service.BookingService;
import com.retailinsights.travelapp.service.InvoiceService;
import com.retailinsights.travelapp.service.SchoolService;

@RestController
public class InvoicesController {

	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private AddressService addressService;

	@PostMapping("/api/v1/invoices")
	public ResponseEntity<Invoices> addInvoices(@RequestBody InvoicesFormDto invoicesDto) {
		Invoices invoice = new Invoices();
		Optional<Address> address = addressService.findById(invoicesDto.getAddress_id());
		Optional<Schools> school = schoolService.findSchoolById(invoicesDto.getSchool_id());
		Optional<Bookings> booking = bookingService.findByBookingId(invoicesDto.getBooking_id());
		invoice.setAddress(address.get());
		invoice.setSchool(school.get());
		invoice.setBooking(booking.get());
		invoice.setDescription(invoicesDto.getDescription());
		invoice.setTrackingStatus(invoicesDto.getTracking_status());
		invoice.setTrackStartedDate(invoicesDto.getTrack_started_date());
		Invoices addedInvoice = invoiceService.addInvoices(invoice);
		return new ResponseEntity<Invoices>(addedInvoice,HttpStatus.CREATED);
	}

	@GetMapping("/api/v1/invoices")
	public List<Invoices> findAllinvoices() {
		List<Invoices> invoicesList = invoiceService.findAllInvoices();
		return invoicesList;
	}

	@GetMapping("/api/v1/invoices/{invoiceId}")
	public Invoices findInvoiceById(@PathVariable UUID invoiceId) {
		Optional<Invoices> invoice = invoiceService.findInvoicesById(invoiceId);
		return invoice.get();
	}

	@DeleteMapping("/api/v1/invoices/{invoiceId}")
	public ResponseEntity deleteInvoice(@PathVariable UUID invoiceId) {
		invoiceService.deleteInvoice(invoiceId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/api/v1/invoices/{invoiceId}")
	public Invoices updateInvoiceData(@PathVariable UUID invoiceId, @RequestBody InvoicesFormDto invoicesFormDto) {
		Optional<Invoices> invoice = invoiceService.findInvoicesById(invoiceId);
		invoice.get().setDescription(invoicesFormDto.getDescription());
		invoice.get().setTrackingStatus(invoicesFormDto.getTracking_status());
		invoice.get().setTrackStartedDate(invoicesFormDto.getTrack_started_date());
		Invoices updatedInvoice = invoiceService.updateInvoice(invoice.get());
		return updatedInvoice;
	}
}
