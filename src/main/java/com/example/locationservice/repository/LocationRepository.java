package com.example.locationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.locationservice.models.Location;
import com.example.locationservice.models.DTO.LocationDTO;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
    @Query("""
        SELECT
            new com.example.locationservice.models.DTO.LocationDTO(
                l.location_id,
                l.address,
                l.postal_code,
                l.city,
                l.province,
                c.country_id,
                c.country_name
            )
        FROM Location l
        JOIN l.country c
    """)
    public List<LocationDTO> get();

    @Query("""
        SELECT
            new com.example.locationservice.models.DTO.LocationDTO(
                l.location_id,
                l.address,
                l.postal_code,
                l.city,
                l.province,
                c.country_id
            )
        FROM Location l
        JOIN l.country c
        WHERE l.location_id = ?1
    """)
    public LocationDTO get(Integer id);
}
