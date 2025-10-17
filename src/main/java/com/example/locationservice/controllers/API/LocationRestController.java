package com.example.locationservice.controllers.API;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.locationservice.services.LocationService;
import com.example.locationservice.utils.ResponseOverloading;

public class LocationRestController {
    private LocationService locationService;

    @Autowired
    public LocationRestController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<Object> get() {
        ResponseOverloading responseOverloading = new ResponseOverloading();
        try {
            return responseOverloading.apiResponse("Success", 200, "Data has been retrived", locationService.getAll());
        } catch (Exception e) {
            e.getMessage();
        }

        return null;
    }
}
