package com.retailinsights.travelapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailinsights.travelapp.entiry.Notification;
import com.retailinsights.travelapp.service.NotificationService;

@RestController
public class NotificationController {

	@Autowired 
	private NotificationService notificationService;
	
	@PostMapping("/api/v1/notifications")
	public ResponseEntity<Notification> addNotification(@RequestBody Notification notification) {
		Notification addedNotification= notificationService.addNotification(notification);
		return new ResponseEntity<Notification>(addedNotification,HttpStatus.CREATED);
	}
}
