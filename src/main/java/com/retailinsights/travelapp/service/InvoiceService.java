package com.retailinsights.travelapp.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Invoices;
import com.retailinsights.travelapp.repo.InvoicesRepository;

@Service
public class InvoiceService {

	@Autowired
	private InvoicesRepository invoiceRepository;
	
	public Invoices addInvoices(Invoices invoice) {
		return invoiceRepository.save(invoice);
	}
	
	public List<Invoices> findAllInvoices(){
		return invoiceRepository.findAll();
	}
	
	public Optional<Invoices> findInvoicesById(UUID invoiceId){
		Optional<Invoices> invoice = invoiceRepository.findById(invoiceId);
		return invoice;
	}
	
	public void deleteInvoice(UUID invoiceId) {
		invoiceRepository.findById(invoiceId);
	}
	
	public Invoices updateInvoice(Invoices invoice) {
		return invoiceRepository.save(invoice);
	}
}


