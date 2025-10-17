package com.example.locationservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.locationservice.models.DTO.CountryDTO;
import com.example.locationservice.models.DTO.LocationDTO;
import com.example.locationservice.services.CountryService;
import com.example.locationservice.services.LocationService;

@Controller
@RequestMapping("location")
public class LocationController {
    private LocationService locationService;
    private CountryService countryService;

    @Autowired
    public LocationController(LocationService locationService, CountryService countryService) {
        this.locationService = locationService;
        this.countryService = countryService;
    }

    @GetMapping
    public String get(Model model) {
       model.addAttribute("locations", locationService.getAll());
       return "location/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id) {
        List<CountryDTO> countries = countryService.getAll();

        if (id != null) {
            LocationDTO locationDTO = locationService.getById(id);
            model.addAttribute("locationDTO", locationDTO);
        } else {
            model.addAttribute("locationDTO", new LocationDTO());
        }

        model.addAttribute("countries", countries);
        return "location/form";
    }

    @PostMapping("save")
    public String save(LocationDTO locationDTO) {
        Boolean result = locationService.save(locationDTO);
        return (result) ?  "redirect:/location" : "location/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Boolean result = locationService.remove(id);
        return (result) ?  "redirect:/location" : "location/index";
    }
}
