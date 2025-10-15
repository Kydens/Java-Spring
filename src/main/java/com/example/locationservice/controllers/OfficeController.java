package com.example.locationservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.locationservice.models.Location;
import com.example.locationservice.models.Office;
import com.example.locationservice.models.DTO.OfficeDTO;
import com.example.locationservice.services.LocationService;
import com.example.locationservice.services.OfficeService;

@Controller
@RequestMapping("office")
public class OfficeController {
    private final OfficeService officeService;
    private final LocationService locationService;

    @Autowired
    public OfficeController(OfficeService officeService, LocationService locationService) {
        this.officeService = officeService;
        this.locationService = locationService;
    }

    @GetMapping
    public String get(Model model) {
        model.addAttribute("offices", officeService.getAll());
        return "office/index";
    }

    @GetMapping("/edit/{id}")
    public String get(@PathVariable("id") Integer id, Model model) {
        List<Location> locations = locationService.getAll();

        Office officeTemp = officeService.getById(id);
        OfficeDTO officeDTO = new OfficeDTO(officeTemp.getOffice_id(), officeTemp.getOffice_name(), officeTemp.getLocation().getLocation_id());

        model.addAttribute("officeDTO", officeDTO);
        model.addAttribute("locations", locations);
        return "office/edit";
    }

    @GetMapping("form")
    public String form(Model model) {
        List<Location> locations = locationService.getAll();

        model.addAttribute("officeDTO", new OfficeDTO());
        model.addAttribute("locations", locations);
        return "office/form";
    }

    @PostMapping("save")
    public String save(OfficeDTO officeDTO) {
        Boolean result = officeService.save(officeDTO);
        if (result) {
            return "redirect:/office";
        }

        return "office/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Boolean result = officeService.remove(id);
        if (result) {
            return "redirect:/office";
        }

        return "office/index";
    }
}
