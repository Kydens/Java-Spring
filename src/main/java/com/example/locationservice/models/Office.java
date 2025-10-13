package com.example.locationservice.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "offices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Office {
    public Office(Integer office_id) {
        this.office_id = office_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer office_id;
    private String office_name;

    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private List<Department> departments;
 
    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;
}

