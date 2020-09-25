package com.retailinsights.travelapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Payments;
import com.retailinsights.travelapp.repo.PaymentsRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentsRepository paymentsRepository;
	
	public Payments addPaymentsdetails(Payments payment) {
		return paymentsRepository.save(payment);
	}
	
	public Optional<Payments> findByPaymentId(UUID paymentId){
		Optional<Payments> paymentDetalis = paymentsRepository.findById(paymentId);
		return paymentDetalis;
	}

	public List<Payments> findAllPayments() {
		List<Payments> paymentsList = paymentsRepository.findAll();
		return paymentsList;
	}

	public void deleteByPaymentId(UUID paymentId) {
		 paymentsRepository.deleteById(paymentId);
	}

	public Payments updatePayment(Payments payments) {
		Payments updatePayment = paymentsRepository.save(payments);
		return updatePayment;
	}
}
