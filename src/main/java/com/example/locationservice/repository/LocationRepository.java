package com.example.locationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.locationservice.models.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
    
}
