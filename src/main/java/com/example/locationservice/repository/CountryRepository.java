package com.example.locationservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.locationservice.models.Country;
import com.example.locationservice.models.DTO.CountryDTO;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("""
        SELECT
            new com.example.locationservice.models.DTO.CountryDTO(
                c.country_id,
                c.country_name,
                c.country_code,
                r.region_id,
                r.region_name
            )
        FROM Country c
        JOIN c.region r
    """)
    public List<CountryDTO> get();

    @Query("""
        SELECT
            new com.example.locationservice.models.DTO.CountryDTO(
                c.country_id,
                c.country_name,
                c.country_code,
                r.region_id
            )
        FROM Country c
        JOIN c.region r
        WHERE c.country_id = ?1
    """)
    public CountryDTO get(Integer id);
}
