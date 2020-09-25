package com.retailinsights.travelapp.exceptions;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TravelExceptionHandling extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest req) {
		String customMsg = ex.getLocalizedMessage();
		if(customMsg==null)
			customMsg = ex.toString();
		CustomExceptionHandling customeException = new CustomExceptionHandling(new Date(), customMsg);
		return new ResponseEntity<>(customeException, new  HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class,AddressNotFoundException.class})
	public ResponseEntity<Object> handleNullPointerException(Exception ex, WebRequest req) {
		String customMsg = ex.getLocalizedMessage();
		if(customMsg==null)
			customMsg = ex.toString();
		CustomExceptionHandling customeException = new CustomExceptionHandling(new Date(), customMsg);
		return new ResponseEntity<>(customeException, new  HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
