package com.example.locationservice.controllers.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.locationservice.models.Country;
import com.example.locationservice.models.DTO.CountryDTO;
import com.example.locationservice.services.CountryService;
import com.example.locationservice.utils.ResponseOverloading;

@RestController
@RequestMapping("api/country")
public class CountryRestController {
    private CountryService countryService;

    @Autowired
    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    // @GetMapping
    // public CountryDTO get(@RequestHeader(name = "token") String token, @RequestParam(name = "id") Integer id) {
    //     if (!token.equals("")) {
    //         if (!token.equals("abcd")) {
    //             return null;
    //         } else {
    //             return countryService.get(id);
    //         }
    //     }

    //     return null;
    // }

    @GetMapping
    public ResponseEntity<Object> get() {
        ResponseOverloading responseOverloading = new ResponseOverloading();

        try {
            return responseOverloading.apiResponse("Success", 200, "Data has retrived", countryService.getAll());
        } catch (Exception e) {
            return responseOverloading.apiResponse("Error", 500, e.getMessage());
        }
    }

    @GetMapping(value = {"form", "form/{id}"})
    public ResponseEntity<Object> get(@PathVariable(required = false) Integer id) {
        ResponseOverloading responseOverloading = new ResponseOverloading();

        try {
            return responseOverloading.apiResponse("Success", 200, "Data has retrived", countryService.get(id));
        } catch (Exception e) {
            return responseOverloading.apiResponse("Error", 500, e.getMessage());
        }
    }

    @PostMapping("save")
    public ResponseEntity<Object> save(@RequestBody CountryDTO countryDTO) {
        ResponseOverloading responseOverloading = new ResponseOverloading();

        try {
            return responseOverloading.apiResponse("Success", 200, "Data has been submit", countryService.save(countryDTO));
        } catch (Exception e) {
            return responseOverloading.apiResponse("Error", 500, e.getMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        ResponseOverloading responseOverloading = new ResponseOverloading();

        try {
            return responseOverloading.apiResponse("Success", 200, "Data has been deleted", countryService.remove(id));
        } catch (Exception e) {
            return responseOverloading.apiResponse("Error", 500, e.getMessage());
        }
    }
}
