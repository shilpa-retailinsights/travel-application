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

import com.retailinsights.travelapp.entiry.Payments;
import com.retailinsights.travelapp.entiry.Student;
import com.retailinsights.travelapp.model.PaymentsFormDto;
import com.retailinsights.travelapp.service.PaymentService;
import com.retailinsights.travelapp.service.StudentService;

@RestController
public class PaymentsController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/api/v1/payments/{paymentId}")
	public Payments findByPaymentId(@PathVariable(name = "paymentId") UUID paymentId){
		Optional<Payments> payment = paymentService.findByPaymentId(paymentId);
		return payment.get();
	}
	
	@PostMapping("/api/v1/payments")
	public ResponseEntity<Payments> addPaymentsDetails(@RequestBody PaymentsFormDto paymentDto) {
		Payments payment = new Payments();
		Optional<Student> sudentsData = studentService.findStudentById(paymentDto.getStudent_id());
		//payment.setId(paymentDto.getId());
		payment.setStudent(sudentsData.get());
		payment.setSuccess(paymentDto.getSuccess());
		payment.setConfirmed(paymentDto.getConfirmed());
		payment.setCreated_at(paymentDto.getCreated_at());
		payment.setCreated_by(paymentDto.getCreated_by());
		payment.setUpdated_at(paymentDto.getUpdatedAt());
		payment.setUpdated_by(paymentDto.getUpdated_by());
		payment.setInitiated_amount(paymentDto.getInitiated_amount());
		payment.setPayment_status(paymentDto.getPayment_status());
		payment.setPayment_method(paymentDto.getPayment_method());
		payment.setActive(paymentDto.getActive());
		payment.setTransactionId(paymentDto.getTransaction_id());
		payment.setTotal_amount(paymentDto.getTotal_amount());
		Payments addeddPayments = paymentService.addPaymentsdetails(payment);
		return new ResponseEntity<Payments>(addeddPayments,HttpStatus.CREATED);
	}
	
	@GetMapping("/api/v1/payments")
	public List<Payments> findAllPayments(){
		List<Payments> paymentList = paymentService.findAllPayments();
		return paymentList;
	}
	
	@DeleteMapping("/api/v1/payments/{paymentId}")
	public ResponseEntity deletePayment(@PathVariable(name = "paymentId") UUID paymentId) {
		 paymentService.deleteByPaymentId(paymentId);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/api/v1/payments/{paymentId}")
	public Payments updatePaymentData(@RequestBody PaymentsFormDto paymentsDto,@PathVariable(name = "paymentId") UUID paymentId) {
		Optional<Payments> payment = paymentService.findByPaymentId(paymentId);
		payment.get().setInitiated_amount(paymentsDto.getInitiated_amount());
		payment.get().setPayment_method(paymentsDto.getPayment_method());
		payment.get().setTotal_amount(paymentsDto.getTotal_amount());
		Payments updatedPayment = paymentService.updatePayment(payment.get());
		return updatedPayment;
	}
}
