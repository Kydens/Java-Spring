package com.example.locationservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.locationservice.models.Department;
import com.example.locationservice.models.Location;
import com.example.locationservice.models.Office;
import com.example.locationservice.models.DTO.DepartmentDTO;
import com.example.locationservice.models.DTO.OfficeDTO;
import com.example.locationservice.services.DepartmentService;
import com.example.locationservice.services.OfficeService;

@Controller
@RequestMapping("department") // request params cth: http://localhost:9000/department
/*
 * getAll() : http://localhost:9000/department
 * getById() : http://localhost:9000/department/1
 * insert() : http://localhost:9000/department
 * remove() : http://localhost:9000/department/1
 */
public class DepartmentController {
    private final DepartmentService departmentService;
    private final OfficeService officeService;

    @Autowired
    public DepartmentController(DepartmentService departmentService, OfficeService officeService) {
        this.departmentService = departmentService;
        this.officeService = officeService;
    }

    /*
     * Request GET
     * Request POST
     */

    @GetMapping
    public String get(Model model) {
        model.addAttribute("departments", departmentService.getAll());
        return "department/index";
    }

    @GetMapping(value = { "form", "form/{id}" })
    public String form(Model model, @PathVariable(required = false) Integer id) {
        List<Office> offices = officeService.getAll();

        if (id != null) {
            DepartmentDTO departmentDTO = departmentService.getById(id);
            model.addAttribute("departmentDTO", departmentDTO);
        } else {
            model.addAttribute("departmentDTO", new DepartmentDTO());
        }

        model.addAttribute("offices", offices);
        return "department/form";
    }

    @PostMapping("save")
    public String save(DepartmentDTO departmentDTO) {
        Boolean result = departmentService.save(departmentDTO);
        if (result) {
            return "redirect:/department";
        }

        return "department/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        Boolean result = departmentService.remove(id);
        if (result) {
            return "redirect:/department";
        }

        return "department/index";
    }
}
