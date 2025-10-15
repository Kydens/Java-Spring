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
    private String countryName;

    public LocationDTO(Integer locationId, String address, Integer postalCode, String city, String province, Integer countryId) {
        this.locationId = locationId;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        this.countryId = countryId;
    }
}
