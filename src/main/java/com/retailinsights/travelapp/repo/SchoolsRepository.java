package com.retailinsights.travelapp.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailinsights.travelapp.entiry.Schools;

@Repository
public interface SchoolsRepository extends JpaRepository<Schools, UUID> {

}
