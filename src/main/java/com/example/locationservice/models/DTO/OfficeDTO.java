package com.example.locationservice.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDTO {
    private Integer office_id;
    private String office_name;
    private Integer department_id;
    private Integer location_id;
}
