package com.retailinsights.travelapp.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailinsights.travelapp.entiry.Payments;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, UUID>{

}
