package com.retailinsights.travelapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailinsights.travelapp.entiry.Packages;

@Repository
public interface PackagesRepository extends JpaRepository<Packages, Integer> {

}
