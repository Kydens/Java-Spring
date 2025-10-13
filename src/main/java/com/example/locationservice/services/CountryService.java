package com.example.locationservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.locationservice.models.Country;
import com.example.locationservice.models.Region;
import com.example.locationservice.models.DTO.CountryDTO;
import com.example.locationservice.repository.CountryRepository;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // find all country
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    // find by id
    public Country getById(Integer id) {
        return countryRepository.findById(id).orElse(null);
    }

    // insert and update
    public Boolean save(CountryDTO countryDTO) {
        Country country = new Country();

        country.setCountry_id(countryDTO.getCountryId());
        country.setCountry_name(countryDTO.getCountryName());
        country.setCountry_code(countryDTO.getCountryCode());
        country.setRegion(new Region(countryDTO.getRegionId()));

        countryRepository.save(country);

        return countryRepository.findById(country.getCountry_id()).isPresent();
    }

    public Boolean remove(Integer id) {
        countryRepository.deleteById(id);
        return !countryRepository.findById(id).isPresent();
    }
}