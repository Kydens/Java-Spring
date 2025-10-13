package com.example.locationservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.locationservice.models.Country;
import com.example.locationservice.models.Location;
import com.example.locationservice.models.DTO.LocationDTO;
import com.example.locationservice.repository.CountryRepository;
import com.example.locationservice.repository.LocationRepository;

@Service
public class LocationService {
    private final LocationRepository locationRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository, CountryRepository countryRepository) {
        this.locationRepository = locationRepository;
        this.countryRepository = countryRepository;
    }
    public List<Location> getAll() {
        return locationRepository.findAll();
    }
    public Location getById(Integer id) {
        return locationRepository.findById(id).orElse(null);
    }
    public Boolean save(LocationDTO locationDTO) {
        Location location = new Location();

        location.setLocation_id(locationDTO.getLocationId());
        location.setAddress(locationDTO.getAddress());
        location.setPostal_code(locationDTO.getPostalCode());
        location.setProvince(locationDTO.getProvince());
        // location.setCountry(new Country(locationDTO.getCountryId()));
        location.setCountry(countryRepository.findById(locationDTO.getCountryId()).orElse(null));

        locationRepository.save(location);

        return locationRepository.findById(location.getLocation_id()).isPresent();
    }
    public Boolean remove(Integer id) {
        locationRepository.deleteById(id);
        return !locationRepository.findById(id).isPresent();
    }
}
