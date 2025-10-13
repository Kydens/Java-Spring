package com.example.locationservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    public Department(Integer department_id) {
        this.department_id = department_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer department_id;
    private String department_name;

    @ManyToOne
    @JoinColumn(name = "office_id", referencedColumnName = "office_id")
    private Office office;
}
