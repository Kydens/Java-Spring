package com.example.locationservice.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    public Region(Integer region_id) {
        this.region_id = region_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer region_id;
    private String region_name;

    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY)
    public List<Country> countries;
}
