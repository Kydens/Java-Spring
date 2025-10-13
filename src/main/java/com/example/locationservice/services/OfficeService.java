package com.example.locationservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.locationservice.models.Department;
import com.example.locationservice.models.Location;
import com.example.locationservice.models.Office;
import com.example.locationservice.models.DTO.OfficeDTO;
import com.example.locationservice.repository.OfficeRepository;

@Service
public class OfficeService {
    private OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public List<Office> getAll() {
        return officeRepository.findAll();
    }

    public Office getById(Integer id) {
        return officeRepository.findById(id).orElse(null);
    }

    public Boolean save(OfficeDTO officeDTO) {
        Office office = new Office();
        
        office.setOffice_id(officeDTO.getOffice_id());
        office.setOffice_name(officeDTO.getOffice_name());

        List<Department> department = new ArrayList<>();
        department.add(new Department(officeDTO.getDepartment_id()));
        office.setDepartments(department);

        office.setLocation(new Location(officeDTO.getLocation_id()));

        officeRepository.save(office);

        return officeRepository.findById(office.getOffice_id()).isPresent();
    }

    public Boolean remove(Integer id) {
        officeRepository.deleteById(id);
        return !officeRepository.findById(id).isPresent();
    }
}
