package com.example.locationservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.locationservice.models.DTO.RegionDTO;
import com.example.locationservice.services.RegionService;

@Controller
@RequestMapping("region")
public class RegionController {
    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("regions", regionService.getAll());
        return "region/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id) {

        if (id != null) {
            RegionDTO regionDTO = regionService.getById(id);
            model.addAttribute("regionDTO", regionDTO);
        } else {
            model.addAttribute("regionDTO", new RegionDTO());
        }
        
        return "region/form";
    }

    @PostMapping("save")
    public String save(RegionDTO regionDTO) {
        Boolean result = regionService.save(regionDTO);
        if (result) {
            return "redirect:/region";
        }

        return "region/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Boolean result = regionService.remove(id);
        if (result) {
            return "redirect:/region";
        }

        return "region/index";
    }
}
