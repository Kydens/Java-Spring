package com.example.locationservice.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountryDTO {
    private Integer countryId;
    private String countryName;
    private String countryCode;
    private Integer regionId;
}
