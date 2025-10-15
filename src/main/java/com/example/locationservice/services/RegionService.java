package com.example.locationservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.locationservice.models.Region;
import com.example.locationservice.models.DTO.RegionDTO;
import com.example.locationservice.repository.RegionRepository;

@Service
public class RegionService {
    private final RegionRepository regionRepository;

    // inject dependencies
    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    // find all region
    public List<RegionDTO> getAll() {
        return regionRepository.get();
    }

    // find by id
    public RegionDTO getById(Integer id) {
        return regionRepository.get(id);
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
