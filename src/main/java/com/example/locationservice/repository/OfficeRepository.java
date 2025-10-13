package com.example.locationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.locationservice.models.Office;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
    
}
