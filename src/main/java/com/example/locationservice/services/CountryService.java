package com.example.locationservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.locationservice.models.Country;
import com.example.locationservice.models.DTO.CountryDTO;
import com.example.locationservice.repository.CountryRepository;
import com.example.locationservice.repository.RegionRepository;

@Service
public class CountryService {
    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository, RegionRepository regionRepository) {
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
    }

    // find all country
    public List<CountryDTO> getAll() {
        return countryRepository.get();
    }

    // find by id
    public CountryDTO get(Integer id) {
        return countryRepository.get(id);
    }

    // insert and update
    public Boolean save(CountryDTO countryDTO) {
        Country country = new Country();

        country.setCountry_id(countryDTO.getCountryId());
        country.setCountry_name(countryDTO.getCountryName());
        country.setCountry_code(countryDTO.getCountryCode());
        // country.setRegion(new Region(countryDTO.getRegionId()));
        country.setRegion(regionRepository.findById(countryDTO.getRegionId()).orElse(null));

        countryRepository.save(country);

        return countryRepository.findById(country.getCountry_id()).isPresent();
    }

    public Boolean remove(Integer id) {
        countryRepository.deleteById(id);
        return !countryRepository.findById(id).isPresent();
    }
}