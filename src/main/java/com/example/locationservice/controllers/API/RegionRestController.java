package com.example.locationservice.controllers.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.locationservice.models.DTO.RegionDTO;
import com.example.locationservice.services.RegionService;
import com.example.locationservice.utils.ResponseGeneralization;

@RestController
@RequestMapping("/api/region")
public class RegionRestController {
    private final RegionService regionService;

    @Autowired
    public RegionRestController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping
    public ResponseEntity<?> get() {
        try {
            return ResponseEntity.status(200).body(new ResponseGeneralization<List<RegionDTO>>("Success", 200, "Data berhasil ditampilkan", regionService.getAll()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseGeneralization<>("Errors", 500, "Data gagal ditampilkan", e.getMessage()));
        }
    }

    @GetMapping(value = {"form", "form/{id}"})
    public ResponseEntity<?> form(@PathVariable(required = false) Integer id) {
        try {
            if (id != null) {
                return ResponseEntity.status(200).body(new ResponseGeneralization<RegionDTO>("Success", 200, "Data berhasil ditampilkan",  regionService.getById(id)));
            } else {
                return ResponseEntity.status(200).body(new ResponseGeneralization<RegionDTO>("Success", 200, "Data berhasil ditampilkan", new RegionDTO()));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseGeneralization<>("Errors", 500, "Data gagal ditampilkan", e.getMessage()));
        }
    }
}
