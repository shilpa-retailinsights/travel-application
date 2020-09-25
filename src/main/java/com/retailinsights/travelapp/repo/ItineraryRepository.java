package com.retailinsights.travelapp.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailinsights.travelapp.entiry.Itinerary;

@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, UUID>{

}
