package com.example.locationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.locationservice.models.Region;
import com.example.locationservice.models.DTO.RegionDTO;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
    @Query("""
        SELECT 
            new com.example.locationservice.models.DTO.RegionDTO(region_id, region_name)
        FROM Region
    """)
    public List<RegionDTO> get();

    @Query("""
        SELECT 
            new com.example.locationservice.models.DTO.RegionDTO(region_id, region_name)
        FROM Region
        WHERE region_id = ?1
    """)
    public RegionDTO get(Integer id);
}
