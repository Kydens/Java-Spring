package com.example.locationservice.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    private Integer locationId;
    private String address;
    private Integer postalCode;
    private String city;
    private String province;
    private Integer countryId;
}
