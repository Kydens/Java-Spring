package com.example.locationservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.locationservice.models.Department;
import com.example.locationservice.models.DTO.DepartmentDTO;
import com.example.locationservice.repository.DepartmentRepository;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Boolean save(DepartmentDTO departmentDTO) {
        Department department = new Department();

        department.setDepartment_id(departmentDTO.getDepartmentId());
        department.setDepartment_name(departmentDTO.getDepartmentName());

        departmentRepository.save(department);

        return departmentRepository.findById(department.getDepartment_id()).isPresent();
    }

    public Boolean remove(Integer id) {
        departmentRepository.deleteById(id);
        return !departmentRepository.findById(id).isPresent();
    }
}
