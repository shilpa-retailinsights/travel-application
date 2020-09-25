package com.retailinsights.travelapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailinsights.travelapp.entiry.Notification;
@Repository
public interface NotificationRepo extends JpaRepository<Notification, Integer>{

}
