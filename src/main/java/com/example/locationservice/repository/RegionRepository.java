package com.example.locationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.locationservice.models.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    
}
