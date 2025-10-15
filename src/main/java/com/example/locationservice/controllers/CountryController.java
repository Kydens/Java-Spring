package com.example.locationservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.locationservice.models.Region;
import com.example.locationservice.models.DTO.CountryDTO;
import com.example.locationservice.models.DTO.RegionDTO;
import com.example.locationservice.services.CountryService;
import com.example.locationservice.services.RegionService;

@Controller
@RequestMapping("country")
public class CountryController {
    private final CountryService countryService;
    private final RegionService regionService;

    @Autowired
    public CountryController(CountryService countryService, RegionService regionService) {
        this.countryService = countryService;
        this.regionService = regionService;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("countries", countryService.getAll());
        return "country/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id) {
        List<RegionDTO> regions = regionService.getAll();

        if (id != null) {
            model.addAttribute("countryDTO",  countryService.get(id));
        } else {  
            model.addAttribute("countryDTO", new CountryDTO());
        }

        model.addAttribute("regions", regions);
        return "country/form";
    }

    @PostMapping("save")
    public String save(CountryDTO countryDTO) {
        Boolean result = countryService.save(countryDTO);
        return (result) ?  "redirect:/country" : "country/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Boolean result = countryService.remove(id);
        return (result) ?  "redirect:/country" : "country/index";
    }
}
