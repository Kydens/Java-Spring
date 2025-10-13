package com.example.locationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.locationservice.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    
}
