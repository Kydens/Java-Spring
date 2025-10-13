package com.example.locationservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.locationservice.models.Region;
import com.example.locationservice.models.DTO.RegionDTO;
import com.example.locationservice.repository.RegionRepository;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    // inject dependencies
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    // find all region
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    // find by id
    public Region getById(Integer id) {
        return regionRepository.findById(id).orElse(null);
    }

    // insert and update
    public Boolean save(RegionDTO regionDTO) {
        Region region = new Region();

        region.setRegion_id(regionDTO.getRegionId());
        region.setRegion_name(regionDTO.getRegionName());

        regionRepository.save(region);

        return regionRepository.findById(region.getRegion_id()).isPresent();
    }

    // delete
    public Boolean remove(Integer id) {
        regionRepository.deleteById(id);
        return !regionRepository.findById(id).isPresent();
    }
}
