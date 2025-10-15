package com.example.locationservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.locationservice.models.Office;
import com.example.locationservice.models.DTO.OfficeDTO;
import com.example.locationservice.repository.DepartmentRepository;
import com.example.locationservice.repository.LocationRepository;
import com.example.locationservice.repository.OfficeRepository;

@Service
public class OfficeService {
    private OfficeRepository officeRepository;
    private LocationRepository locationRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public OfficeService(OfficeRepository officeRepository, DepartmentRepository departmentRepository, LocationRepository locationRepository) {
        this.officeRepository = officeRepository;
        this.departmentRepository = departmentRepository;
        this.locationRepository = locationRepository;
    }

    public List<Office> getAll() {
        return officeRepository.findAll();
    }

    public Office getById(Integer id) {
        return officeRepository.findById(id).orElse(null);
    }

    public Boolean save(OfficeDTO officeDTO) {
        Office office = new Office();
        
        office.setOffice_id(officeDTO.getOfficeId());
        office.setOffice_name(officeDTO.getOfficeName());   
        office.setLocation(locationRepository.findById(officeDTO.getLocationId()).orElse(null));

        officeRepository.save(office);

        return officeRepository.findById(office.getOffice_id()).isPresent();
    }

    public Boolean remove(Integer id) {
        departmentRepository.deleteByOfficeId(id);
        officeRepository.deleteById(id);
        return !officeRepository.findById(id).isPresent();
    }
}
