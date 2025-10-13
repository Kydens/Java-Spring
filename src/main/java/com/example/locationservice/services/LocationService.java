package com.example.locationservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.locationservice.models.Country;
import com.example.locationservice.models.Location;
import com.example.locationservice.models.DTO.LocationDTO;
import com.example.locationservice.repository.LocationRepository;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
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
        location.setCountry(new Country(locationDTO.getCountryId()));

        locationRepository.save(location);

        return locationRepository.findById(location.getLocation_id()).isPresent();
    }
    public Boolean remove(Integer id) {
        locationRepository.deleteById(id);
        return !locationRepository.findById(id).isPresent();
    }
}
