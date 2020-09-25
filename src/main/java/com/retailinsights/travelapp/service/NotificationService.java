package com.retailinsights.travelapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailinsights.travelapp.entiry.Notification;
import com.retailinsights.travelapp.repo.NotificationRepo;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepo notificationRepo;
	
	public Notification addNotification(Notification notification) {
		return notificationRepo.save(notification);
	}
}
